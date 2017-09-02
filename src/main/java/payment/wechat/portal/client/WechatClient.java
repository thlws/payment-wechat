/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package payment.wechat.portal.client;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import payment.wechat.api.WechatApi;
import payment.wechat.core.WechatCore;
import payment.wechat.entity.input.*;
import payment.wechat.entity.output.*;
import payment.wechat.utils.ConnUtil;
import payment.wechat.utils.DataUtil;
import payment.wechat.utils.WechatUtil;
import payment.wechat.utils.XmlUtil;

import java.util.Map;


/**
 * 微信支付相关[非公众号支付]
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class WechatClient implements WechatApi{

	static final protected Logger log = LoggerFactory.getLogger(WechatClient.class);


	/**
	 * 申请小微收款识别码
	 * @param o           the o
	 * @param apiKey      the api key
	 * @param p12FilePath the p 12 file path
	 * @return the micro mch output
	 */
	public static MicroMchOutput postMicroMch(MicroMchInput o, String apiKey,String p12FilePath){
		MicroMchOutput resp = null;
		try {
			Map<String, Object> mapData = DataUtil.data2Map(o);
			mapData = DataUtil.dataFilter(mapData);
			String sign = WechatUtil.sign4wechat(mapData,apiKey);
			mapData.put("sign", sign);
			MicroMchInput xwr = (MicroMchInput) DataUtil.mapToObject(mapData,MicroMchInput.class);

			String nonceStr = DataUtil.getRandomString(32);//随机生成32为的字符串
			xwr.setNonce_str(nonceStr);

			XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
			xStream.alias("xml", MicroMchInput.class);
			String xml = xStream.toXML(xwr);
			log.info("申请小微收款识别码 [submchmanage] xml request:\n"+xml);

			//p12FilePath = "/zone/1.p12";
			String xmlResp = ConnUtil.encryptPost(xml, micro_mch_add, o.getMch_id(), p12FilePath);
			log.info("申请小微收款识别码 [submchmanage] xml response:\n"+XmlUtil.format(xmlResp));
			XStream xStreamOut = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
			xStreamOut.alias("xml", MicroMchOutput.class);
			resp = (MicroMchOutput) xStreamOut.fromXML(xmlResp);
		} catch (Exception e) {
			log.error("申请小微收款识别码失败:"+e.getMessage());
		}

		return resp;

	}


	/***
	 * build request data for wechat ~ query submch
	 * api:https://api.mch.weixin.qq.com/secapi/mch/submchmanage?action=query
	 * @author HanleyTang
	 * @param o
	 * @param apiKey
	 * @return
	 */
	public static String queryMicroMch(MicroMchInput o, String apiKey,String p12FilePath){

		try {
			Map<String, Object> mapData = DataUtil.data2Map(o);
			mapData = DataUtil.dataFilter(mapData);
			String sign = WechatUtil.sign4wechat(mapData,apiKey);
			mapData.put("sign", sign);
			MicroMchInput xwr = (MicroMchInput) DataUtil.mapToObject(mapData,MicroMchInput.class);
			xwr.setNonce_str(DataUtil.getRandomString(32));

			XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
			xStream.alias("xml", MicroMchInput.class);
			String xml = xStream.toXML(xwr);
			log.info("查询小微收款人资料[submchmanage?action=query] xml request:\n"+xml);

			String result =ConnUtil.encryptPost(xml, micro_mch_qry, o.getMch_id(), p12FilePath);
			log.info("查询小微收款人资料[submchmanage?action=query] xml response:\n"+result);
		} catch (Exception e) {

		}

		return null;

	}


	/***
	 * 统一下单接口
	 * @author HanleyTang
	 * @param data
	 * @param apiKey
	 * @return
	 */
	public static UnifiedOrderOutput unifiedorder(UnifiedOrderInput data, String apiKey){

		return WechatCore.unifiedorder(data,apiKey);
	}

	public static WechatRefundOutput refund(WechatRefundInput data, String apiKey,String p12FilePath){

		return WechatCore.refund(data,apiKey,p12FilePath);

	}

	public static WechatReverseOutput reverse(WechatReverseInput data, String apiKey,String p12FilePath){
		return WechatCore.reverse(data,apiKey,p12FilePath);
	}




	/***
	 * 微信刷卡支付
	 * @param input
	 * @param apiKey
	 * @return
	 */
	public static WechatPayOutput micropay(WechatPayInput input,String apiKey){

		WechatPayOutput output = null;
		Map<String, Object>  dataMap = DataUtil.data2Map(input);
		dataMap = DataUtil.dataFilter(dataMap);
		String sign = WechatUtil.sign4wechat(dataMap,apiKey);
		dataMap.put("sign",sign);
		input = (WechatPayInput) DataUtil.mapToObject(dataMap,WechatPayInput.class);

		XStream xStream = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
		xStream.alias("xml", WechatPayInput.class);
		String xml = xStream.toXML(input);
		log.info("微信支付请求数据[micropay]->xmlRequest:\n"+xml);
		try {
			String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_micropay);
			log.info("微信支付响应数据[micropay]->response xmlResponse:\n"+ XmlUtil.format(xmlResponse));
			XStream xStreamOut = new XStream(new XppDriver(new XmlFriendlyReplacer("_-", "_")));
			xStreamOut.alias("xml", WechatPayOutput.class);
			output = (WechatPayOutput) xStreamOut.fromXML(xmlResponse);
		} catch (Exception e) {
			log.error("微信线下支付失败:"+e.getMessage());
		}

		return output;
	}

	public static OrderQueryOutput orderQuery(OrderQueryInput input, String apiKey){
		return	WechatCore.orderQuery(input,apiKey);
	}

	public static CloseOrderOutput closeOrder(CloseOrderInput input,String apiKey){
		return WechatCore.closeOrder(input,apiKey);
	}
	

}
