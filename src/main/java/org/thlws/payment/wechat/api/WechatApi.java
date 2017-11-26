package org.thlws.payment.wechat.api;


/**
 * 微信官方API列表  <br>
 * @see <a href="https://pay.weixin.qq.com/guide/index.shtml">https://pay.weixin.qq.com/guide/index.shtml</a>
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/sl.html">https://pay.weixin.qq.com/wiki/doc/api/sl.html</a>
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/index.html">https://pay.weixin.qq.com/wiki/doc/api/index.html</a>
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public interface WechatApi {

	/***
	 * Q&A
	 * Q1:为什么公众号上没有微信支付(线上)?
	 * A1:微信公众号支付在微信网页完成的,支付前需要调用统一下单接口.
	 *
	 * Q2:微信支付到底有几种方式?
	 * A2:微信官方支付方式包括:公众号支付、扫码支付、刷卡支付.
	 *
	 * Q3:该项目到底支持哪几种微信支付？
	 * A3:目前没有全部支持微信官方的支付方式,截止目前支持 公众号支付、刷卡支付 两种支付方式.
	 *
	 * Q4:扫码支付后续是否可以提供AllInOne的支付API?
	 * A4:不可以,扫描支付与公众号支付类似,是在用户手机上完成支付的,支付前需要调用统一下单接口.
	 */



	/**
	 * 获取微信token[非普通token],使用code得到oauth2方式的 access_token,据此获取用户信息,openId,userInfo etc...
	 */
	String oauth2_access_token = "https://api.weixin.qq.com/sns/oauth2/access_token";

	/**
	 * 刷新token[非普通token]
	 */
	String oauth2_refresh_token = "https://api.weixin.qq.com/sns/oauth2/refresh_token";

	/**
	 * 验证token是否过期[非普通token]
	 */
	String sns_auth_token = "https://api.weixin.qq.com/sns/auth";

	/**
	 * 获取用户信息,URL scope需为userinfo
	 */
	String sns_userinfo = "https://api.weixin.qq.com/sns/userinfo";

	/**
	 * 微信统一下单
	 */
	String pay_unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	/**
	 * 微信退款,需使用p12证书
	 */
	String pay_refund = "https://api.mch.weixin.qq.com/secapi/pay/refund";

	/**
	 * 微信线下支付-[刷卡支付]
	 */
	String pay_micropay = "https://api.mch.weixin.qq.com/pay/micropay";

	/**
	 * 微信订单查询
	 */
	String pay_orderquery = "https://api.mch.weixin.qq.com/pay/orderquery";

	/**
	 * 撤销订单,需使用p12证书
	 */
	String pay_reverse = "https://api.mch.weixin.qq.com/secapi/pay/reverse";

	/**微信关闭订单*/
	String close_order = "https://api.mch.weixin.qq.com/pay/closeorder";

	/***
	 * 获取普通token
	 */
	String cgibin_token = "https://api.weixin.qq.com/cgi-bin/token";

	/***
	 * 获取jsapi ticket
	 */
	String cgi_bin_ticket_getticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";

	/***
	 * 获取消息模板ID
	 */
	String cgibin_add_template = "https://api.weixin.qq.com/cgi-bin/template/api_add_template";

	/***
	 * 设置行业属性
	 */
	String cgibin_set_industry = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry";

	/***
	 * 发送微信推送通知
	 */
	String cgibin_send_data = "https://api.weixin.qq.com/cgi-bin/message/template/send";

	/**
	 * 新增个人微信收款
	 * 未使用
	 */
	String micro_mch_add = "https://api.mch.weixin.qq.com/secapi/mch/submchmanage?action=add";

	/**
	 * 查询个人微信收款人信息
	 * 未使用
	 */
	String micro_mch_qry = "https://api.mch.weixin.qq.com/secapi/mch/submchmanage?action=query";

}
