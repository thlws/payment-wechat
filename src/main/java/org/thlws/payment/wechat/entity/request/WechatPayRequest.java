package org.thlws.payment.wechat.entity.request;

import org.thlws.payment.wechat.utils.JsonUtil;

/***
 * 微信刷卡支付参数对象
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class WechatPayRequest {

	/**用户在公众号下标识*/
	private String openid           ;

	/**公众账号ID*/
	private String appid            ;

	/**商户号*/
	private String mch_id           ;

	/**随机字符串	*/
	private String nonce_str        ;

	/**签名*/
	private String sign             ;

	/**商品描述	*/
	private String body             ;

	/**订单总金额*/
	private String total_fee        ;

	/**调用微信支付API的机器IP */
	private String spbill_create_ip ;

	/**商户订单号	*/
	private String out_trade_no		;

	/**条码或者二维码信息*/
	private String auth_code		;	//y	   线下支付-[条码或者二维码信息]

	/**商品详情*/
	private String detail			;	//n    not required

	/**附加数据,小微模式必须填写为 收款识别码	*/
	private String attach			;	//n    not required

	/**符合ISO 4217标准的三位字母代码，默认人民币：CNY*/
	private String fee_type			;	//n    not required

	/**订单优惠标记*/
	private String goods_tag		;	//n    not required

	/**设备号	*/
	private String device_info		;	//n    not required

	/**指定支付方式*/
	private String limit_pay		;	//n    not required

	/**子商户公众账号ID*/
	private String sub_appid		;	//n    not required

	/**子商户号,普通模式无需设置,子商户需设置子商户号,小微模式固定填1000077001	*/
	private String sub_mch_id		;	//n    not required

	/**
	 * 场景信息
	 * <p>
	 *     该字段用于上报场景信息，目前支持上报实际门店信息。
	 *     该字段为JSON数据格式，示例代码
	 *     <code>{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }}</code>
	 * </p>
	 * <br>
	 * <span style="color:red">该栏位必须为JSON数据格式</span>
	 * <code>
	 *     scene_info = WStoreInfo.create("19871008","我们的店","21980","阆中市");
	 * </code>
	 * <br>
	 * {@link org.thlws.payment.wechat.entity.extra.WStoreInfo}
	 * */
	private String scene_info;

	/**
	 * Instantiates a new Wechat pay request.
	 */
	public WechatPayRequest() {}

	/**
	 * Gets sub appid.
	 *
	 * @return the sub appid
	 */
	public String getSub_appid() {
		return sub_appid;
	}

	/**
	 * Sets sub appid.
	 *
	 * @param sub_appid the sub appid
	 */
	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	/**
	 * Gets sub mch id.
	 *
	 * @return the sub mch id
	 */
	public String getSub_mch_id() {
		return sub_mch_id;
	}

	/**
	 * Sets sub mch id.
	 *
	 * @param sub_mch_id the sub mch id
	 */
	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	/**
	 * Gets openid.
	 *
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * Gets appid.
	 *
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * Gets mch id.
	 *
	 * @return the mch id
	 */
	public String getMch_id() {
		return mch_id;
	}

	/**
	 * Gets nonce str.
	 *
	 * @return the nonce str
	 */
	public String getNonce_str() {
		return nonce_str;
	}

	/**
	 * Gets sign.
	 *
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * Gets body.
	 *
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Gets total fee.
	 *
	 * @return the total fee
	 */
	public String getTotal_fee() {
		return total_fee;
	}

	/**
	 * Gets spbill create ip.
	 *
	 * @return the spbill create ip
	 */
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	/**
	 * Gets out trade no.
	 *
	 * @return the out trade no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * Gets detail.
	 *
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * Gets attach.
	 *
	 * @return the attach
	 */
	public String getAttach() {
		return attach;
	}

	/**
	 * Gets fee type.
	 *
	 * @return the fee type
	 */
	public String getFee_type() {
		return fee_type;
	}

	/**
	 * Gets goods tag.
	 *
	 * @return the goods tag
	 */
	public String getGoods_tag() {
		return goods_tag;
	}

	/**
	 * Gets device info.
	 *
	 * @return the device info
	 */
	public String getDevice_info() {
		return device_info;
	}

	/**
	 * Gets limit pay.
	 *
	 * @return the limit pay
	 */
	public String getLimit_pay() {
		return limit_pay;
	}

	/**
	 * Sets openid.
	 *
	 * @param openid the openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * Sets appid.
	 *
	 * @param appid the appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * Sets mch id.
	 *
	 * @param mch_id the mch id
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	/**
	 * Sets nonce str.
	 *
	 * @param nonce_str the nonce str
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	/**
	 * Sets sign.
	 *
	 * @param sign the sign
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * Sets body.
	 *
	 * @param body the body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * Sets total fee.
	 *
	 * @param total_fee the total fee
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * Sets spbill create ip.
	 *
	 * @param spbill_create_ip the spbill create ip
	 */
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	/**
	 * Sets out trade no.
	 *
	 * @param out_trade_no the out trade no
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * Sets detail.
	 *
	 * @param detail the detail
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * Sets attach.
	 *
	 * @param attach the attach
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * Sets fee type.
	 *
	 * @param fee_type the fee type
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	/**
	 * Sets goods tag.
	 *
	 * @param goods_tag the goods tag
	 */
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	/**
	 * Sets device info.
	 *
	 * @param device_info the device info
	 */
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	/**
	 * Sets limit pay.
	 *
	 * @param limit_pay the limit pay
	 */
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	/**
	 * Gets auth code.
	 *
	 * @return the auth code
	 */
	public String getAuth_code() {
		return auth_code;
	}

	/**
	 * Sets auth code.
	 *
	 * @param auth_code the auth code
	 */
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
