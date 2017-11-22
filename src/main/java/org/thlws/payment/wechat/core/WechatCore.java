package org.thlws.payment.wechat.core;

import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.api.WechatApi;
import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.*;
import org.thlws.payment.wechat.extra.xml.XStreamCreator;
import org.thlws.payment.wechat.utils.ConnUtil;
import org.thlws.payment.wechat.utils.DataUtil;
import org.thlws.payment.wechat.utils.WechatUtil;
import org.thlws.payment.wechat.utils.XmlUtil;

import java.util.Map;

/**
 * The type Wechat core.
 */
public class WechatCore implements WechatApi{

    /**
     * The Log.
     */
    static final private Logger log = LoggerFactory.getLogger(WechatCore.class);

    /**
     * 微信统一下单，同时支援公众号统一下单 和 微信公众号统一下单
     *
     * @param data   the data
     * @param apiKey the api key
     * @return the unified order output 统一下单结果
     */
    public static UnifiedOrderOutput unifiedorder(UnifiedOrderInput data, String apiKey){

        UnifiedOrderOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,UnifiedOrderInput.class,apiKey);
            XStream xStream =  XStreamCreator.create(UnifiedOrderInput.class);
            String xml = xStream.toXML(input);
            log.info("微信统一下单请求数据[unifiedorder]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_unifiedorder);
            log.info("微信统一下单返回数据[unifiedorder]->xmlResponse:\n"+ XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(UnifiedOrderOutput.class);
            output = (UnifiedOrderOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
            log.info("微信统一下单[unifiedorder]失败:"+e.getMessage());
        }

        return output;

    }


    /**
     * 微信退款
     *
     * @param data        the data 退款必要参数
     * @param apiKey      the api key 微信API秘钥
     * @param p12FilePath the p 12 file path 微信p12文件路径
     * @return the wechat refund output 微信退款结果
     */
    public static WechatRefundOutput refund(WechatRefundInput data, String apiKey, String p12FilePath){

        WechatRefundOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,WechatRefundInput.class,apiKey);
            XStream xStream = XStreamCreator.create(WechatRefundInput.class);
            String xml = xStream.toXML(input);
            log.info("微信退款请求数据[refund]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.encryptPost(xml, pay_refund, data.getMch_id(), p12FilePath);
            log.info("微信退款响应数据[refund]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(WechatRefundOutput.class);
            output = (WechatRefundOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信退款[refund]失败:"+e.getMessage());
        }
        return output;

    }


    /**
     * 微信订单查询
     *
     * @param data  the input
     * @param apiKey the api key
     * @return the order query output
     */
    public static OrderQueryOutput orderQuery(OrderQueryInput data, String apiKey){

        OrderQueryOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,OrderQueryInput.class,apiKey);
            XStream xStream =  XStreamCreator.create(OrderQueryInput.class);
            String xml = xStream.toXML(input);
            log.info("微信订单查询请求数据[orderQuery]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_orderquery);
            log.info("微信订单查询响应数据[orderQuery]->response xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut =  XStreamCreator.create(OrderQueryOutput.class);
            output = (OrderQueryOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
           log.error("微信订单查询失败:"+e.getMessage());
        }

        return  output;
    }


    /**
     * Reverse wechat reverse output.
     *
     * @param data        the data
     * @param apiKey      the api key
     * @param p12FilePath the p 12 file path
     * @return the wechat reverse output
     */
    public static WechatReverseOutput reverse(WechatReverseInput data, String apiKey, String p12FilePath){

        WechatReverseOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,WechatReverseInput.class,apiKey);
            XStream xStream = XStreamCreator.create(WechatReverseInput.class);
            String xml = xStream.toXML(input);
            log.info("微信撤销订单请求数据[reverse]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.encryptPost(xml, pay_reverse, data.getMch_id(), p12FilePath);
            log.info("微信撤销订单响应数据[reverse]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(WechatReverseOutput.class);
            output = (WechatReverseOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信撤销订单[reverse]失败:"+e.getMessage());
        }
        return output;

    }


    /**
     * Close order close order output.
     *
     * @param data   the data
     * @param apiKey the api key
     * @return the close order output
     */
    public static CloseOrderOutput closeOrder(CloseOrderInput data, String apiKey){

        CloseOrderOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,CloseOrderInput.class,apiKey);
            XStream xStream = XStreamCreator.create(CloseOrderInput.class);
            String xml = xStream.toXML(input);
            log.info("微信关闭订单请求数据[closeOrder]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,close_order);

            log.info("微信关闭订单响应数据[closeOrder]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(CloseOrderOutput.class);
            output = (CloseOrderOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信关闭订单[closeOrder]失败:"+e.getMessage());
        }
        return output;
    }


    /***
     * 微信刷卡支付
     * @param data
     * @param apiKey
     * @return
     */
    public static WechatPayOutput micropay(WechatPayInput data, String apiKey){

        WechatPayOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,WechatPayInput.class,apiKey);
            XStream xStream = XStreamCreator.create(WechatPayInput.class);
            String xml = xStream.toXML(input);
            log.info("微信支付请求数据[micropay]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_micropay);
            log.info("微信支付响应数据[micropay]->response xmlResponse:\n"+ XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(WechatPayOutput.class);
            output = (WechatPayOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
            log.error("微信线下支付失败:"+e.getMessage());
        }

        return output;
    }

}
