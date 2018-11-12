/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.thlws.payment.wechat.utils;

import com.thoughtworks.xstream.XStream;
import org.thlws.payment.wechat.entity.response.NotifyResponse;
import org.thlws.payment.wechat.entity.response.UnifiedOrderResponse;
import org.thlws.payment.wechat.extra.xml.XStreamCreator;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HanleyTang on 16/9/4.
 */
public class WechatUtil {

    /**
     * sign wechat request data
     *
     * @param params the params
     * @param key    the key
     * @return string string
     * @author HanleyTang
     */
    public static String sign(Map<String, Object> params, String key){

        String prestr = ThlwsBeanUtil.createLinkString(params);
        prestr +="&key="+key;
        String mysign = ThlwsBeanUtil.getMD5(prestr).toUpperCase();
        return mysign;
    }


    /**
     * 微信支付异步通知结果解析为Object
     *
     * @param xmlResult the xml result
     * @return notify response
     */
    public static NotifyResponse parseNotifyMsg(String xmlResult){

        XStream xStream = XStreamCreator.create(NotifyResponse.class);
        NotifyResponse output = (NotifyResponse) xStream.fromXML(xmlResult);
        return output;
    }

    /**
     * Build request object.
     *
     * @param o      the o
     * @param clz    the clz
     * @param apiKey the api key
     * @return the object
     */
    public static Object buildRequest(Object o, Class clz,String apiKey){
        Map<String, Object> mapData = ThlwsBeanUtil.ObjectToMap(o);
        String sign = WechatUtil.sign(mapData,apiKey);
        mapData.put("sign", sign);
        return ThlwsBeanUtil.mapToObject(mapData,clz);
    }

    /**
     * The entry point of application.
     *
     * @param args the request arguments
     */
    public static void main(String[] args) {
        String notifyXmlResult = "<xml><appid><![CDATA[wx5f22a16d8c94dba4]]></appid><attach><![CDATA[69a8ef0cb3c742779c438e92bbc33118]]></attach><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><device_info><![CDATA[hanley@1025@cust_test]]></device_info><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1336236101]]></mch_id><nonce_str><![CDATA[txjam10ant72jxl5umsl2hbl2nrb0kzr]]></nonce_str><openid><![CDATA[o2nMlwuj_cHFBcNDfPkpufta80KU]]></openid><out_trade_no><![CDATA[20170224052028]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[D8D69790FB5416AF86070B4DAD673E89]]></sign><time_end><![CDATA[20170224052134]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4005332001201702241084568187]]></transaction_id></xml>";
        parseNotifyMsg(notifyXmlResult);
    }


    /***
     * 微信 H5 公众号支付，数据处理（存入request,返回jsp页面时用于发起H5支付）
     * @param request the request
     * @param response the response
     * @param outTradeNo the out trade no
     * @param apiKey the api key
     */
    public static void h5_pay(HttpServletRequest request
            , UnifiedOrderResponse response
            , String outTradeNo
            , String apiKey){

        long time = System.currentTimeMillis() / 1000;
        String timeStamp = String.valueOf(time);
        String appId = response.getAppid();
        String nonceStr = response.getNonce_str();
        String _package = "prepay_id=" + response.getPrepay_id();
        Map<String, Object> sParam = new HashMap<String, Object>();
        sParam.put("appId", appId);
        sParam.put("timeStamp",timeStamp);
        sParam.put("nonceStr", nonceStr);
        sParam.put("package", _package);
        sParam.put("signType", "MD5");
        String paySign = org.thlws.payment.wechat.utils.WechatUtil.sign(sParam, apiKey);
        request.setAttribute("appId", appId);
        request.setAttribute("timeStamp", timeStamp);
        request.setAttribute("nonceStr", nonceStr);
        request.setAttribute("packageStr", _package);
        request.setAttribute("signType", "MD5");
        request.setAttribute("paySign", paySign);
        request.setAttribute("outTradeNo", outTradeNo);
    }
}
