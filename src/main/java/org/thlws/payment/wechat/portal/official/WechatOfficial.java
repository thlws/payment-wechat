package org.thlws.payment.wechat.portal.official;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.entity.output.*;
import org.thlws.payment.wechat.api.WechatApi;
import org.thlws.payment.wechat.utils.ConnUtil;
import org.thlws.payment.wechat.utils.DataUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * 微信公众号相关
 * @author Hanley Tang
 * @version 1.0
 * @email hanley@hanley.cn
 */
public class WechatOfficial implements WechatApi{

	static final protected Logger log = LoggerFactory.getLogger(WechatOfficial.class);

	/***
	 * 通过code换取网页授权access_token
	 * access_token是调用授权关系接口的调用凭证，有效期为2个小时,频率限制:1万/分钟
	 *
	 * @author HanleyTang
	 * @param mapToken
	 */
	public static OauthTokenOutput obtainOauthAccessToken(Map<String, Object> mapToken){
		
//		 mapToken.put("appid", appId);
//		 mapToken.put("secret", appSecret);
//		 mapToken.put("code", code);
//		 mapToken.put("grant_type", "authorization_code");
		OauthTokenOutput resp = null;
		String params = DataUtil.map2Param(mapToken);
		StringBuffer sb = new StringBuffer(oauth2_access_token);
		sb.append("?").append(params);
		System.out.print(sb.toString());
		try {
			String jr = ConnUtil.connURL(sb.toString());
			System.out.println("\n\n*****************************");
			System.out.println("微信取OpenId resp="+jr);
			System.out.println("\n\n*****************************");
			resp = JSONObject.parseObject(jr, OauthTokenOutput.class);
		} catch (Exception e) {
			resp = null;
		}
		return resp;
		
	}
	
	/**
	 * 刷新access_token（如果需要）
	 * 当access_token超时后，可以使用refresh_token进行刷新，access_token刷新结果有两种
	 * 1. 若access_token已超时，那么进行refresh_token会获取一个新的access_token，新的超时时间；
	 * 2. 若access_token未超时，那么进行refresh_token不会改变access_token，但超时时间会刷新，相当于续期access_token。
	 * refresh_token拥有较长的有效期（30天），当refresh_token失效的后，需要用户重新授权。
	 * 频率限制:5万/分钟
	 * @author HanleyTang
	 * @param mapToken
	 */
	public static OauthTokenOutput refreshOauthAccessToken(Map<String, Object> mapToken){
		
//		 mapToken.put("appid", appId);
//		 mapToken.put("refresh_token", '填写通过access_token获取到的refresh_token参数');
//		 mapToken.put("grant_type", "refresh_token");
		OauthTokenOutput resp = null;
		String params = DataUtil.map2Param(mapToken);
		StringBuffer sb = new StringBuffer(oauth2_refresh_token);
		sb.append("?").append(params);
		try {
			String jr = ConnUtil.connURL(sb.toString());
			resp = JSONObject.parseObject(jr, OauthTokenOutput.class);
		} catch (Exception e) {
			resp = null;
			e.printStackTrace();
		}
		return resp;
		
	}


	/***
	 * wechat URL链接生成，
	 * scope取值为:snsapi_base[无需用户授权] 或 userinfo[需用户授权]
	 * state 为自定义参数,非必须
	 * redirect_uri 微信处理完成后，会直接转向至该地址
	 * @return
     */
	public static  String generateWechatUrl(String appId,String scope,String callback,String bizData){
		StringBuffer sb = new StringBuffer();
		sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?");
		sb.append("appid=").append(appId);
		sb.append("&redirect_uri=").append(callback);
		sb.append("&response_type=code&");
		sb.append("scope=").append(scope);
		sb.append("&state=").append(bizData);
		sb.append("#wechat_redirect");
		return  sb.toString();
	}


	/***
	 * 获取微信用户个人信息
	 * 所需参数：access_token、openid、lang[非必须]
	 * lang 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
	 * 频率限制:5万/分钟
	 * @param userInfoMap
	 * @return
     */
	public static UserInfoOutput obtainUserInfo(Map<String, Object> userInfoMap){
		 
//		Map<String, Object> userInfoMap = new HashMap<String, Object>();
//		 userInfoMap.put("access_token", accessToken);
//		 userInfoMap.put("openid", openId);
//		 userInfoMap.put("lang", "zh_CN");
		
		UserInfoOutput resp = null;
		
		String params = DataUtil.map2Param(userInfoMap);
		StringBuffer sb = new StringBuffer(sns_userinfo);
		sb.append("?").append(params);
		try {
			String jr = ConnUtil.connURL(sb.toString());
			resp = JSONObject.parseObject(jr, UserInfoOutput.class);
		} catch (Exception e) {
			resp = null;
			e.printStackTrace();
		}
		return resp;
	}
	
	
	/***
	 * 检验授权凭证（access_token）是否有效
	 * @author HanleyTang
	 * @param mapToken
	 * @return
	 */
	public static boolean IsvalidOauthAccessToken(Map<String, Object> mapToken){
		
//		 mapToken.put("access_token", access_token);
//		 mapToken.put("openid", '');
		boolean flag = false;
		String params = DataUtil.map2Param(mapToken);
		StringBuffer sb = new StringBuffer(sns_auth_token);
		sb.append("?").append(params);
		try {
			String result = ConnUtil.connURL(sb.toString());
			JSONObject jr = JSONObject.parseObject(result);
			String rcode = jr.getString("errcode");
			if (rcode.equalsIgnoreCase("0")){
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
		
	}
	

	/***
	 * access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。
	 * 开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。
	 * access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
	 *
	 * 关于网页授权access_token和普通access_token的区别
	 * 1、微信网页授权是通过OAuth2.0机制实现的，在用户授权给公众号后，公众号可以获取到一个
	 * 网页授权特有的接口调用凭证（网页授权access_token），通过网页授权access_token可以进行授权后接口调用，如获取用户基本信息；
	 * 2、其他微信接口，需要通过基础支持中的“获取access_token”接口来获取到的普通access_token调用。
	 * @param appid
	 * @param secret
     * @return
     */
	public static TokenOutput obtainAccessToken(String appid, String secret){
		TokenOutput resp = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(cgibin_token).append("?");
			sb.append("grant_type=client_credential").append("&").append("appid=").append(appid).append("&").append("secret=").append(secret);
			String jr = ConnUtil.connURL(sb.toString());
			resp = JSONObject.parseObject(jr, TokenOutput.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return resp;
	}


	/***
	 * 获取jsapi_ticket，jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket
	 * 的有效期为7200秒，通过access_token来获取。由于获取jsapi_ticket的api调用次数非常有限， 频繁刷新
	 * jsapi_ticket会导致api调用受限，影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket 。
	 * @param token 普通token
	 * @return
     */
	public static JsApiTicketOutput obtainJsApiTicket(String token){
		JsApiTicketOutput resp = null;
		try {

//			String eg = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=giPthFJplKI1fux6WxFqelRdqAa317wlC4zWRsnUUHVse20nm2dYpL5w0h-HJGFiAoZ8Mk3aCr0f7rLRGRn2ifZjzyrg_cHKCbvrozdEeCGO617WESe8f1g1UCX2BzSfCWOjAJAWQI&type=jsapi";
			StringBuffer sb = new StringBuffer();
			sb.append(cgi_bin_ticket_getticket).append("?");
			sb.append("access_token=").append(token).append("&type=jsapi");
			String jr = ConnUtil.connURL(sb.toString());
			resp = JSONObject.parseObject(jr, JsApiTicketOutput.class);
		} catch (Exception e) {
			resp = null;
			System.out.println(e.getMessage());
		}
		return resp;
	}


	/***
	 * 功能同上，但不建议使用,token需要中控服务器维护
	 * @param appid
	 * @param secret
     * @return
     */
	public static JsApiTicketOutput obtainJsApiTicket(String appid, String secret){

		TokenOutput tokenResp = obtainAccessToken(appid,secret);
		String token = tokenResp.getAccess_token();
		JsApiTicketOutput resp = obtainJsApiTicket(token);

		return resp;
	}


	/***
	 * 获取微信消息模板ID{根据微信template_id_short得到,实际动作是调用API往 ‘我的模板’ 中添加了模板}
	 * @param access_token
	 * @param template_id_short
     * @return
     */
	public static TemplateOutput obtainTemplateId(String access_token,String template_id_short){

		TemplateOutput output = null;

		try{
			StringBuffer sb = new StringBuffer();
			sb.append(cgibin_add_template);
			sb.append("?access_token=");
			sb.append(access_token);

			HashMap<String,String> mapData = new HashMap<String,String>();
			mapData.put("template_id_short", template_id_short);
			String json = JSONObject.toJSONString(mapData);

			String result = ConnUtil.connRemoteWithJson(json,sb.toString());
			output = JSONObject.parseObject(result,TemplateOutput.class);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

		return output;
	}


	/***
	 * 设置行业属性
	 * @param access_token
	 * @param industry_id1
	 * @param industry_id2
     * @return
     */
	public static IndustryOutput setupIndustry(String access_token, String industry_id1, String industry_id2){

		IndustryOutput output = null;

		try {
			StringBuffer sb = new StringBuffer();
			sb.append(cgibin_set_industry);
			sb.append("?access_token=");
			sb.append(access_token);

			HashMap<String,String> mapData = new HashMap<String,String>();
			mapData.put("industry_id1", industry_id1);
			mapData.put("industry_id2", industry_id2);
			String json = JSONObject.toJSONString(mapData);
			String result = ConnUtil.connRemoteWithJson(json,sb.toString());
			log.info("setupIndustry result="+result);
			output = JSONObject.parseObject(result,IndustryOutput.class);
		}catch (Exception e){
			System.out.println(e.getMessage());
			log.error("setupIndustry error:"+e.getMessage());
		}

		return output;
	}

	/***
	 * 发送数据至于用户公微信所关注的微信公账号
	 * @param access_token
	 * @param data json格式数据
     * @return
     */
	public static SendDataOutput sendData2wechat(String access_token, String data){

		SendDataOutput output = null;
		try {
			//String data = "{\"touser\":\"o2nMlwuj_cHFBcNDfPkpufta80KU\",\"template_id\":\"NeaRJdq_j97Vi6iskaapH6D-5k6uFJ_aoEn6mJpIFwI\",\"url\":\"http://test.iquickgo.com/mstore/myVirtual2.html\",\"data\":{\"first\":{\"value\":\"您的积分账户变更如下\",\"color\":\"#173177\"},\"account\":{\"value\":\"会员名称\",\"color\":\"#000000\"},\"time\":{\"value\":\"2016-11-15 16:57:10\",\"color\":\"#000000\"},\"type\":{\"value\":\"线上消费赠返积分\",\"color\":\"#000000\"},\"creditChange\":{\"value\":\"赠送\",\"color\":\"#000000\"},\"number\":{\"value\":\"39\",\"color\":\"#000000\"},\"creditName\":{\"value\":\"积分\",\"color\":\"#000000\"},\"amount\":{\"value\":\"700\",\"color\":\"#000000\"},\"remark\":{\"value\":\"积分可以在商城消费哦\",\"color\":\"#000000\"}}}";
			StringBuffer sb = new StringBuffer();
			sb.append(cgibin_send_data);
			sb.append("?access_token=");
			sb.append(access_token);
			String result = ConnUtil.connRemoteWithJson(data, sb.toString());
			output = JSONObject.parseObject(result,SendDataOutput.class);
			log.info("send data result:"+result);
		}catch (Exception e){
			log.error("sendData2wechat error:"+e.getMessage());
		}

		return output;
	}

}
