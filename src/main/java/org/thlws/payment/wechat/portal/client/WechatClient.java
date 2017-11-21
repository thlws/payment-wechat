/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.thlws.payment.wechat.portal.client;

import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.api.WechatApi;
import org.thlws.payment.wechat.core.WechatCore;
import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.*;
import org.thlws.payment.wechat.extra.xml.XStreamCreator;
import org.thlws.payment.wechat.utils.ConnUtil;
import org.thlws.payment.wechat.utils.DataUtil;
import org.thlws.payment.wechat.utils.WechatUtil;
import org.thlws.payment.wechat.utils.XmlUtil;


import java.util.Map;


/**
 * 微信支付相关[非公众号支付]
 *
 * @author Hanley Tang/ hanley@thlws.com
 * @version 1.0
 */
public class WechatClient implements WechatApi {

	static final private Logger log = LoggerFactory.getLogger(WechatClient.class);


	/**
	 * 申请小微收款识别码
	 *
	 * @param o           the o
	 * @param apiKey      the api key
	 * @param p12FilePath the p 12 file path
	 * @return the micro mch output
	 */
	public static MicroMchOutput postMicroMch(MicroMchInput o, String apiKey, String p12FilePath){
		MicroMchOutput resp = null;
		try {
			Map<String, Object> mapData = DataUtil.data2Map(o);
			mapData = DataUtil.dataFilter(mapData);
			String sign = WechatUtil.sign4wechat(mapData,apiKey);
			mapData.put("sign", sign);
			MicroMchInput xwr = (MicroMchInput) DataUtil.mapToObject(mapData,MicroMchInput.class);

			String nonceStr = DataUtil.getRandomString(32);//随机生成32为的字符串
			xwr.setNonce_str(nonceStr);

			XStream xStream = XStreamCreator.create();
			xStream.alias("xml", MicroMchInput.class);
			String xml = xStream.toXML(xwr);
			log.info("申请小微收款识别码 [submchmanage] xml request:\n"+xml);

			//p12FilePath = "/zone/1.p12";
			String xmlResp = ConnUtil.encryptPost(xml, micro_mch_add, o.getMch_id(), p12FilePath);
			log.info("申请小微收款识别码 [submchmanage] xml response:\n"+ XmlUtil.format(xmlResp));
			XStream xStreamOut = XStreamCreator.create();
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
	 * @param o the o
	 * @param apiKey the api key
	 * @param p12FilePath the p 12 file path
	 * @return string
	 * @author HanleyTang
	 */
	public static String queryMicroMch(MicroMchInput o, String apiKey, String p12FilePath){

		String result = "";
		try {
			Map<String, Object> mapData = DataUtil.data2Map(o);
			mapData = DataUtil.dataFilter(mapData);
			String sign = WechatUtil.sign4wechat(mapData,apiKey);
			mapData.put("sign", sign);
			MicroMchInput xwr = (MicroMchInput) DataUtil.mapToObject(mapData,MicroMchInput.class);
			xwr.setNonce_str(DataUtil.getRandomString(32));

			XStream xStream = XStreamCreator.create();
			xStream.alias("xml", MicroMchInput.class);
			String xml = xStream.toXML(xwr);
			log.info("查询小微收款人资料[submchmanage?action=query] xml request:\n"+xml);

			result =ConnUtil.encryptPost(xml, micro_mch_qry, o.getMch_id(), p12FilePath);
			log.info("查询小微收款人资料[submchmanage?action=query] xml response:\n"+result);
		} catch (Exception e) {
			log.error("queryMicroMch error:"+e.getMessage());
		}
		return result;

	}


	/***
	 * 统一下单接口
	 * @param data the data
	 * @param apiKey the api key
	 * @return unified order output
	 * @author HanleyTang
	 */
	public static UnifiedOrderOutput unifiedorder(UnifiedOrderInput data, String apiKey){

		return WechatCore.unifiedorder(data,apiKey);
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

		return WechatCore.refund(data,apiKey,p12FilePath);

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
		return WechatCore.reverse(data,apiKey,p12FilePath);
	}


	/**
	 * Micropay wechat pay output.
	 *
	 * @param input  the input
	 * @param apiKey the api key
	 * @return the wechat pay output
	 */
	public static WechatPayOutput micropay(WechatPayInput input, String apiKey){
		return WechatCore.micropay(input,apiKey);
	}

	/**
	 * Order query order query output.
	 *
	 * @param input  the input
	 * @param apiKey the api key
	 * @return the order query output
	 */
	public static OrderQueryOutput orderQuery(OrderQueryInput input, String apiKey){
		return	WechatCore.orderQuery(input,apiKey);
	}

	/**
	 * Close order close order output.
	 *
	 * @param input  the input
	 * @param apiKey the api key
	 * @return the close order output
	 */
	public static CloseOrderOutput closeOrder(CloseOrderInput input,String apiKey){
		return WechatCore.closeOrder(input,apiKey);
	}
	

}
