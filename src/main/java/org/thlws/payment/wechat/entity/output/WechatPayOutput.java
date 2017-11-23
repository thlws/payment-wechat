package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 微信刷卡支付返回对象
 *
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class WechatPayOutput {

	/**返回状态码*/
	private String return_code;

	/**返回信息*/
	private String return_msg ;

	/**公众账号ID	*/
	private String appid      ;

	/**商户号	*/
	private String mch_id     ;

	/**随机字符串	*/
	private String nonce_str  ;

	/**签名*/
	private String sign       ;

	/**业务结果*/
	private String result_code;

	/**交易类型,MICROPAY(即扫码支付)*/
	private String trade_type ;

	/**用户标识*/
	private String openid;

	/**是否关注公众账号*/
	private String is_subscribe;

	/**付款银行*/
	private String bank_type;

	/**符合ISO 4217标准的三位字母代码，默认人民币：CNY*/
	private String fee_type;

	/**订单总金额*/
	private String total_fee;

	/**现金支付币种*/
	private String cash_fee_type;

	/**现金支付金额*/
	private String cash_fee;

	/**微信支付订单号*/
	private String transaction_id;

	/**商户订单号*/
	private String out_trade_no;

	/**商家数据包*/
	private String attach;

	/**支付完成时间*/
	private String time_end;

	/**设备号	*/
	private String device_info;

	/**错误代码*/
	private String err_code;

	/**错误代码描述*/
	private String err_code_des;

	/**代金券金额,“代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额*/
	private String coupon_fee;

	/**子商户公众账号ID*/
	private String sub_appid		;	//n    not required

	/**子商户号*/
	private String sub_mch_id		;	//n    not required

	/**用户子标识*/
	private String sub_openid		;	//n    not required

	/**是否关注子公众账号*/
	private String sub_is_subscribe	;	//n    not required

	/**
	 * 应结订单金额
	 * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额
	 * */
	private String settlement_total_fee; //n    not required


	/**
	 * Instantiates a new Wechat pay output.
	 */
	public WechatPayOutput() {
	}

	/**
	 * Gets coupon fee.
	 *
	 * @return the coupon fee
	 */
	public String getCoupon_fee() {
		return coupon_fee;
	}

	/**
	 * Sets coupon fee.
	 *
	 * @param coupon_fee the coupon fee
	 */
	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	/**
	 * Gets sub openid.
	 *
	 * @return the sub openid
	 */
	public String getSub_openid() {
		return sub_openid;
	}

	/**
	 * Sets sub openid.
	 *
	 * @param sub_openid the sub openid
	 */
	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	/**
	 * Gets sub is subscribe.
	 *
	 * @return the sub is subscribe
	 */
	public String getSub_is_subscribe() {
		return sub_is_subscribe;
	}

	/**
	 * Sets sub is subscribe.
	 *
	 * @param sub_is_subscribe the sub is subscribe
	 */
	public void setSub_is_subscribe(String sub_is_subscribe) {
		this.sub_is_subscribe = sub_is_subscribe;
	}

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
	 * Gets device info.
	 *
	 * @return the device info
	 */
	public String getDevice_info() {
		return device_info;
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
	 * Gets err code.
	 *
	 * @return the err code
	 */
	public String getErr_code() {
		return err_code;
	}

	/**
	 * Sets err code.
	 *
	 * @param err_code the err code
	 */
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	/**
	 * Gets err code des.
	 *
	 * @return the err code des
	 */
	public String getErr_code_des() {
		return err_code_des;
	}

	/**
	 * Sets err code des.
	 *
	 * @param err_code_des the err code des
	 */
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	/**
	 * Gets return code.
	 *
	 * @return the return code
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * Gets return msg.
	 *
	 * @return the return msg
	 */
	public String getReturn_msg() {
		return return_msg;
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
	 * Gets result code.
	 *
	 * @return the result code
	 */
	public String getResult_code() {
		return result_code;
	}

	/**
	 * Gets trade type.
	 *
	 * @return the trade type
	 */
	public String getTrade_type() {
		return trade_type;
	}

	/**
	 * Sets return code.
	 *
	 * @param return_code the return code
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	/**
	 * Sets return msg.
	 *
	 * @param return_msg the return msg
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
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
	 * Sets result code.
	 *
	 * @param result_code the result code
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	/**
	 * Sets trade type.
	 *
	 * @param trade_type the trade type
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
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
	 * Sets openid.
	 *
	 * @param openid the openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * Gets is subscribe.
	 *
	 * @return the is subscribe
	 */
	public String getIs_subscribe() {
		return is_subscribe;
	}

	/**
	 * Sets is subscribe.
	 *
	 * @param is_subscribe the is subscribe
	 */
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	/**
	 * Gets bank type.
	 *
	 * @return the bank type
	 */
	public String getBank_type() {
		return bank_type;
	}

	/**
	 * Sets bank type.
	 *
	 * @param bank_type the bank type
	 */
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
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
	 * Sets fee type.
	 *
	 * @param fee_type the fee type
	 */
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
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
	 * Sets total fee.
	 *
	 * @param total_fee the total fee
	 */
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * Gets cash fee type.
	 *
	 * @return the cash fee type
	 */
	public String getCash_fee_type() {
		return cash_fee_type;
	}

	/**
	 * Sets cash fee type.
	 *
	 * @param cash_fee_type the cash fee type
	 */
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	/**
	 * Gets cash fee.
	 *
	 * @return the cash fee
	 */
	public String getCash_fee() {
		return cash_fee;
	}

	/**
	 * Sets cash fee.
	 *
	 * @param cash_fee the cash fee
	 */
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	/**
	 * Gets transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}

	/**
	 * Sets transaction id.
	 *
	 * @param transaction_id the transaction id
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
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
	 * Sets out trade no.
	 *
	 * @param out_trade_no the out trade no
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
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
	 * Sets attach.
	 *
	 * @param attach the attach
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/**
	 * Gets time end.
	 *
	 * @return the time end
	 */
	public String getTime_end() {
		return time_end;
	}

	/**
	 * Sets time end.
	 *
	 * @param time_end the time end
	 */
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
