package org.thlws.payment.wechat.core;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.api.WechatApi;
import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.OrderQueryOutput;
import org.thlws.payment.wechat.entity.output.UnifiedOrderOutput;
import org.thlws.payment.wechat.entity.output.WechatRefundOutput;
import org.thlws.payment.wechat.entity.output.WechatReverseOutput;
import org.thlws.payment.wechat.utils.ConnUtil;
import org.thlws.payment.wechat.utils.DataUtil;
import org.thlws.payment.wechat.utils.WechatUtil;
import org.thlws.payment.wechat.utils.XmlUtil;

import java.util.Map;

/**
 * 微信核心API处理[线上&线下共用] {@link WechatApi}
 * Created by HanleyTang on 16/9/4.
 */
public class WechatCore implements WechatApi{

    static final protected Logger log = LoggerFactory.getLogger(WechatCore.class);

    /***
     * 统一下单接口，应用场景：除被扫支付场景以外，商户系统先调用该接口
     * 在微信支付服务后台生成预支付交易单，返回正确的预支付交易回话标识
     * 后再按扫码、JSAPI、APP等不同场景生成交易串调起支付。
     * @author HanleyTang
     * @param data
     * @param apiKey
     * data.notifyUrl 提供给微信的回调地址
     * @return 统一下单完成封装后的数据对象
     */
    public static UnifiedOrderOutput unifiedorder(UnifiedOrderInput data, String apiKey){

        UnifiedOrderOutput output = null;

        Map<String, Object> mapData = DataUtil.data2Map(data);
        mapData = DataUtil.dataFilter(mapData);
        String sign = WechatUtil.sign4wechat(mapData,apiKey);
        mapData.put("sign", sign);
        UnifiedOrderInput input = (UnifiedOrderInput) DataUtil.mapToObject(mapData,UnifiedOrderInput.class);

        XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
        xStream.alias("xml", UnifiedOrderInput.class);
        String xml = xStream.toXML(input);
        log.info("微信统一下单请求数据[unifiedorder]->xmlRequest:\n"+xml);
        try {
            //xml=new String(xml.getBytes(),"ISO8859-1");
            String xmlResponse = ConnUtil.postDataToWechat(xml,pay_unifiedorder);
//            String xmlResponse = ConnUtil.connRemoteWithXml(xml, pay_unifiedorder);
            log.info("微信统一下单返回数据[unifiedorder]->xmlResponse:\n"+ XmlUtil.format(xmlResponse));
            XStream xStream2 = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStream2.alias("xml", UnifiedOrderOutput.class);
            output = (UnifiedOrderOutput) xStream2.fromXML(xmlResponse);
        } catch (Exception e) {
            log.info("微信统一下单[unifiedorder]失败:"+e.getMessage());
        }

        return output;

    }


    /**
     * 微信退款接口 @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_4">https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_4</a>
     * 应用场景:当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款
     * 接口将支付款退还给买家，微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款
     * 按原路退到买家帐号上，需注意如下事项：
     * 1.交易时间超过一年的订单无法提交退款；
     * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。总退款金额不能超过用户实际支付金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号。
     * @param data        the data
     * @param apiKey      the api key
     * @param p12FilePath the p 12 file path
     * @return the wechat refund output
     */
    public static WechatRefundOutput refund(WechatRefundInput data, String apiKey, String p12FilePath){

        WechatRefundOutput output = null;

        try {
            Map<String, Object> mapData = DataUtil.data2Map(data);
            mapData = DataUtil.dataFilter(mapData);
            String sign = WechatUtil.sign4wechat(mapData,apiKey);
            mapData.put("sign", sign);
            data.setSign(sign);
            WechatRefundInput xwr = (WechatRefundInput) DataUtil.mapToObject(mapData,WechatRefundInput.class);

            XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStream.alias("xml", WechatRefundInput.class);
            String xml = xStream.toXML(xwr);
            log.info("微信退款请求数据[refund]->xmlRequest:\n"+xml);

            //p12FilePath = "/zone/1386246702.p12";

            String xmlResponse = ConnUtil.encryptPost(xml, pay_refund, data.getMch_id(), p12FilePath);
            log.info("微信退款响应数据[refund]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStreamOut.alias("xml", WechatRefundOutput.class);
            output = (WechatRefundOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信退款[refund]失败:"+e.getMessage());
        }
        return output;

    }


    /***
     * 微信订单查询
     * @param input 查询参数
     * @param apiKey API秘钥
     * @return 查询结果
     */
    public static OrderQueryOutput orderQuery(OrderQueryInput input, String apiKey){

        OrderQueryOutput output = null;

        Map<String, Object> mapData = DataUtil.data2Map(input);
        mapData = DataUtil.dataFilter(mapData);
        String sign = WechatUtil.sign4wechat(mapData,apiKey);
        mapData.put("sign",sign);
        input = (OrderQueryInput)DataUtil.mapToObject(mapData,OrderQueryInput.class);

        XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
        xStream.alias("xml", OrderQueryInput.class);
        String xml = xStream.toXML(input);
        log.info("微信订单查询请求数据[orderQuery]->xmlRequest:\n"+xml);
        try {
            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_orderquery);
            log.info("微信订单查询响应数据[orderQuery]->response xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStreamOut.alias("xml", OrderQueryOutput.class);
            output = (OrderQueryOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
           log.error("微信订单查询失败:"+e.getMessage());
        }

        return  output;
    }


    /***
     * 微信撤销订单
     * @param data
     * @param apiKey
     * @param p12FilePath
     * @return
     */
    public static WechatReverseOutput reverse(WechatReverseInput data, String apiKey, String p12FilePath){

        WechatReverseOutput output = null;

        try {
            Map<String, Object> mapData = DataUtil.data2Map(data);
            mapData = DataUtil.dataFilter(mapData);
            String sign = WechatUtil.sign4wechat(mapData,apiKey);
            mapData.put("sign", sign);
            data.setSign(sign);
            WechatReverseInput xwr = (WechatReverseInput) DataUtil.mapToObject(mapData,WechatReverseInput.class);

            XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStream.alias("xml", WechatReverseInput.class);
            String xml = xStream.toXML(xwr);
            log.info("微信撤销订单请求数据[reverse]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.encryptPost(xml, pay_reverse, data.getMch_id(), p12FilePath);
            log.info("微信撤销订单响应数据[reverse]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStreamOut.alias("xml", WechatReverseOutput.class);
            output = (WechatReverseOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信撤销订单[reverse]失败:"+e.getMessage());
        }
        return output;

    }


    /**
     * Close order close order output.
     * @param data   the data
     * @param apiKey the api key
     * @return the close order output
     */
    public static CloseOrderOutput closeOrder(CloseOrderInput data, String apiKey){
        CloseOrderOutput output = null;
        try {
            Map<String, Object> mapData = DataUtil.data2Map(data);
            mapData = DataUtil.dataFilter(mapData);
            String sign = WechatUtil.sign4wechat(mapData,apiKey);
            mapData.put("sign", sign);
            data.setSign(sign);
            CloseOrderInput xwr = (CloseOrderInput) DataUtil.mapToObject(mapData,CloseOrderInput.class);

            XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStream.alias("xml", CloseOrderInput.class);
            String xml = xStream.toXML(xwr);
            log.info("微信关闭订单请求数据[closeOrder]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,close_order);

            log.info("微信关闭订单响应数据[closeOrder]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
            xStreamOut.alias("xml", CloseOrderOutput.class);
            output = (CloseOrderOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信关闭订单[closeOrder]失败:"+e.getMessage());
        }
        return output;
    }


}
