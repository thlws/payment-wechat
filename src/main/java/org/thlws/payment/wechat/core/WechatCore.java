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
     * Unifiedorder unified order output.
     *
     * @param data   the data
     * @param apiKey the api key
     * @return the unified order output
     */
    public static UnifiedOrderOutput unifiedorder(UnifiedOrderInput data, String apiKey){

        UnifiedOrderOutput output = null;

        Map<String, Object> mapData = DataUtil.data2Map(data);
        mapData = DataUtil.dataFilter(mapData);
        String sign = WechatUtil.sign4wechat(mapData,apiKey);
        mapData.put("sign", sign);
        UnifiedOrderInput input = (UnifiedOrderInput) DataUtil.mapToObject(mapData,UnifiedOrderInput.class);

        XStream xStream =  XStreamCreator.create();
        xStream.alias("xml", UnifiedOrderInput.class);
        String xml = xStream.toXML(input);
        log.info("微信统一下单请求数据[unifiedorder]->xmlRequest:\n"+xml);
        try {
            String xmlResponse = ConnUtil.postDataToWechat(xml,pay_unifiedorder);
            log.info("微信统一下单返回数据[unifiedorder]->xmlResponse:\n"+ XmlUtil.format(xmlResponse));
            XStream xStream2 = XStreamCreator.create();
            xStream2.alias("xml", UnifiedOrderOutput.class);
            output = (UnifiedOrderOutput) xStream2.fromXML(xmlResponse);
        } catch (Exception e) {
            log.info("微信统一下单[unifiedorder]失败:"+e.getMessage());
        }

        return output;

    }


    /**
     * Refund wechat refund output.
     *
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

            XStream xStream = XStreamCreator.create();
            xStream.alias("xml", WechatRefundInput.class);
            String xml = xStream.toXML(xwr);
            log.info("微信退款请求数据[refund]->xmlRequest:\n"+xml);

            //p12FilePath = "/zone/1386246702.p12";

            String xmlResponse = ConnUtil.encryptPost(xml, pay_refund, data.getMch_id(), p12FilePath);
            log.info("微信退款响应数据[refund]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create();
            xStreamOut.alias("xml", WechatRefundOutput.class);
            output = (WechatRefundOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信退款[refund]失败:"+e.getMessage());
        }
        return output;

    }


    /**
     * Order query order query output.
     *
     * @param input  the input
     * @param apiKey the api key
     * @return the order query output
     */
    public static OrderQueryOutput orderQuery(OrderQueryInput input, String apiKey){

        OrderQueryOutput output = null;

        Map<String, Object> mapData = DataUtil.data2Map(input);
        mapData = DataUtil.dataFilter(mapData);
        String sign = WechatUtil.sign4wechat(mapData,apiKey);
        mapData.put("sign",sign);
        input = (OrderQueryInput)DataUtil.mapToObject(mapData,OrderQueryInput.class);

        XStream xStream =  XStreamCreator.create();
        xStream.alias("xml", OrderQueryInput.class);
        String xml = xStream.toXML(input);
        log.info("微信订单查询请求数据[orderQuery]->xmlRequest:\n"+xml);
        try {
            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_orderquery);
            log.info("微信订单查询响应数据[orderQuery]->response xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut =  XStreamCreator.create();
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
            Map<String, Object> mapData = DataUtil.data2Map(data);
            mapData = DataUtil.dataFilter(mapData);
            String sign = WechatUtil.sign4wechat(mapData,apiKey);
            mapData.put("sign", sign);
            data.setSign(sign);
            WechatReverseInput xwr = (WechatReverseInput) DataUtil.mapToObject(mapData,WechatReverseInput.class);

            XStream xStream = XStreamCreator.create();
            xStream.alias("xml", WechatReverseInput.class);
            String xml = xStream.toXML(xwr);
            log.info("微信撤销订单请求数据[reverse]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.encryptPost(xml, pay_reverse, data.getMch_id(), p12FilePath);
            log.info("微信撤销订单响应数据[reverse]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create();
            xStreamOut.alias("xml", WechatReverseOutput.class);
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
            Map<String, Object> mapData = DataUtil.data2Map(data);
            mapData = DataUtil.dataFilter(mapData);
            String sign = WechatUtil.sign4wechat(mapData,apiKey);
            mapData.put("sign", sign);
            data.setSign(sign);
            CloseOrderInput xwr = (CloseOrderInput) DataUtil.mapToObject(mapData,CloseOrderInput.class);

            XStream xStream = XStreamCreator.create();
            xStream.alias("xml", CloseOrderInput.class);
            String xml = xStream.toXML(xwr);
            log.info("微信关闭订单请求数据[closeOrder]->xmlRequest:\n"+xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,close_order);

            log.info("微信关闭订单响应数据[closeOrder]->xmlResponse:\n"+XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create();
            xStreamOut.alias("xml", CloseOrderOutput.class);
            output = (CloseOrderOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信关闭订单[closeOrder]失败:"+e.getMessage());
        }
        return output;
    }


    /***
     * 微信刷卡支付
     * @param input
     * @param apiKey
     * @return
     */
    public static WechatPayOutput micropay(WechatPayInput input, String apiKey){

        WechatPayOutput output = null;
        Map<String, Object>  dataMap = DataUtil.data2Map(input);
        dataMap = DataUtil.dataFilter(dataMap);
        String sign = WechatUtil.sign4wechat(dataMap,apiKey);
        dataMap.put("sign",sign);
        input = (WechatPayInput) DataUtil.mapToObject(dataMap,WechatPayInput.class);

        XStream xStream = XStreamCreator.create();
        xStream.alias("xml", WechatPayInput.class);
        String xml = xStream.toXML(input);
        log.info("微信支付请求数据[micropay]->xmlRequest:\n"+xml);
        try {
            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_micropay);
            log.info("微信支付响应数据[micropay]->response xmlResponse:\n"+ XmlUtil.format(xmlResponse));
            XStream xStreamOut = XStreamCreator.create();
            xStreamOut.alias("xml", WechatPayOutput.class);
            output = (WechatPayOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
            log.error("微信线下支付失败:"+e.getMessage());
        }

        return output;
    }

}
