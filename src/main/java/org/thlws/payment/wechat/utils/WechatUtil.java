/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.thlws.payment.wechat.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.thlws.payment.wechat.entity.output.NotifyOutput;
import org.thlws.payment.wechat.extra.xml.XStreamCreator;

import java.util.Map;

/**
 * Created by HanleyTang on 16/9/4.
 */
public class WechatUtil {

    /**
     * sign wechat request data
     * @author HanleyTang
     * @param params
     * @param key
     * @return
     */
    public static String sign4wechat(Map<String, Object> params, String key){

        String prestr = DataUtil.createLinkString(params);
        prestr +="&key="+key;
        String mysign = DataUtil.getMD5(prestr).toUpperCase();
        return mysign;
    }


    /**
     * 微信支付异步通知结果解析为Object
     * @param xmlResult
     * @return
     */
    public static NotifyOutput parseNotifyMsg(String xmlResult){

        XStream xStream = XStreamCreator.create();
        xStream.alias("xml", NotifyOutput.class);
        NotifyOutput output = (NotifyOutput) xStream.fromXML(xmlResult);
        System.out.println(output.toString());
        return output;
    }


    public static void main(String[] args) {
        String notifyXmlResult = "<xml><appid><![CDATA[wx5f22a16d8c94dba4]]></appid><attach><![CDATA[69a8ef0cb3c742779c438e92bbc33118]]></attach><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><device_info><![CDATA[hanley@1025@cust_test]]></device_info><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[1336236101]]></mch_id><nonce_str><![CDATA[txjam10ant72jxl5umsl2hbl2nrb0kzr]]></nonce_str><openid><![CDATA[o2nMlwuj_cHFBcNDfPkpufta80KU]]></openid><out_trade_no><![CDATA[20170224052028]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[D8D69790FB5416AF86070B4DAD673E89]]></sign><time_end><![CDATA[20170224052134]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4005332001201702241084568187]]></transaction_id></xml>";
        parseNotifyMsg(notifyXmlResult);
    }
}
