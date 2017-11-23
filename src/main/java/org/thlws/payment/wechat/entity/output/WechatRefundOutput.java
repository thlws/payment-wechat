package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/***
 * 微信退款返回对象
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class WechatRefundOutput {

	/**返回状态码*/
	private String return_code          ;

	/**返回信息*/
	private String return_msg           ;

	/**业务结果*/
	private String result_code          ;

	/**错误代码*/
	private String err_code             ;

	/**错误代码描述*/
	private String err_code_des         ;

	/**公众账号ID*/
	private String appid                ;

	/**商户号*/
	private String mch_id               ;

	/***/
	private String device_info          ;

	/**随机字符串*/
	private String nonce_str            ;

	/**签名*/
	private String sign                 ;

	/**微信订单号*/
	private String transaction_id       ;

	/**商户订单号*/
	private String out_trade_no         ;

	/**商户退款单号*/
	private String out_refund_no        ;

	/**微信退款单号*/
	private String refund_id            ;

	/**文档返回参数列表中无该参数，但DEMO示例存在,暂时保留 FIXME*/
	private String refund_channel       ;

	/**申请退款金额*/
	private String refund_fee           ;

	/**退款金额*/
	private String settlement_refund_fee;

	/**订单金额*/
	private String total_fee            ;

	/**
	 * 应结订单金额<br>
	 * 应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额
	 * */
	private String settlement_total_fee ;

	/**订单金额货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY*/
	private String fee_type             ;

	/**现金支付金额*/
	private String cash_fee             ;

	/**现金退款金额*/
	private String cash_refund_fee      ;

	/**代金券退款总金额*/
	private String coupon_refund_fee	;

	/**退款代金券使用数量*/
	private String coupon_refund_count	;

	/**子商户公众账号ID*/
	private String sub_appid;

	/**子商户号*/
	private String sub_mch_id;

	/**代金券类型-0*/
	private String coupon_type_0;

	/**代金券类型-1*/
	private String coupon_type_1;

	/**代金券类型-2*/
	private String coupon_type_2;

	/**退款代金券ID-0*/
	private String coupon_refund_id_0;

	/**退款代金券ID-1*/
	private String coupon_refund_id_1;

	/**退款代金券ID-2*/
	private String coupon_refund_id_2;

	/**单个代金券退款金额-0*/
	private String coupon_refund_fee_0;

	/**单个代金券退款金额-1*/
	private String coupon_refund_fee_1;

	/**单个代金券退款金额-2*/
	private String coupon_refund_fee_2;

	/**
	 * Instantiates a new Wechat refund output.
	 */
	public WechatRefundOutput(){}

	/**
	 * Gets coupon refund count.
	 *
	 * @return the coupon refund count
	 */
	public String getCoupon_refund_count() {
		return coupon_refund_count;
	}

	/**
	 * Sets coupon refund count.
	 *
	 * @param coupon_refund_count the coupon refund count
	 */
	public void setCoupon_refund_count(String coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
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
	 * Gets return code.
	 *
	 * @return the return code
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * Gets coupon refund fee.
	 *
	 * @return the coupon refund fee
	 */
	public String getCoupon_refund_fee() {
		return coupon_refund_fee;
	}

	/**
	 * Sets coupon refund fee.
	 *
	 * @param coupon_refund_fee the coupon refund fee
	 */
	public void setCoupon_refund_fee(String coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
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
	 * Gets result code.
	 *
	 * @return the result code
	 */
	public String getResult_code() {
		return result_code;
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
	 * Gets err code des.
	 *
	 * @return the err code des
	 */
	public String getErr_code_des() {
		return err_code_des;
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
	 * Gets device info.
	 *
	 * @return the device info
	 */
	public String getDevice_info() {
		return device_info;
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
	 * Gets transaction id.
	 *
	 * @return the transaction id
	 */
	public String getTransaction_id() {
		return transaction_id;
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
	 * Gets out refund no.
	 *
	 * @return the out refund no
	 */
	public String getOut_refund_no() {
		return out_refund_no;
	}


	/**
	 * Gets refund id.
	 *
	 * @return the refund id
	 */
	public String getRefund_id() {
		return refund_id;
	}


	/**
	 * Gets refund channel.
	 *
	 * @return the refund channel
	 */
	public String getRefund_channel() {
		return refund_channel;
	}


	/**
	 * Gets refund fee.
	 *
	 * @return the refund fee
	 */
	public String getRefund_fee() {
		return refund_fee;
	}


	/**
	 * Gets settlement refund fee.
	 *
	 * @return the settlement refund fee
	 */
	public String getSettlement_refund_fee() {
		return settlement_refund_fee;
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
	 * Gets settlement total fee.
	 *
	 * @return the settlement total fee
	 */
	public String getSettlement_total_fee() {
		return settlement_total_fee;
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
	 * Gets cash fee.
	 *
	 * @return the cash fee
	 */
	public String getCash_fee() {
		return cash_fee;
	}


	/**
	 * Gets cash refund fee.
	 *
	 * @return the cash refund fee
	 */
	public String getCash_refund_fee() {
		return cash_refund_fee;
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
	 * Sets result code.
	 *
	 * @param result_code the result code
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
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
	 * Sets err code des.
	 *
	 * @param err_code_des the err code des
	 */
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
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
	 * Sets device info.
	 *
	 * @param device_info the device info
	 */
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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
	 * Sets transaction id.
	 *
	 * @param transaction_id the transaction id
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
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
	 * Sets out refund no.
	 *
	 * @param out_refund_no the out refund no
	 */
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}


	/**
	 * Sets refund id.
	 *
	 * @param refund_id the refund id
	 */
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}


	/**
	 * Sets refund channel.
	 *
	 * @param refund_channel the refund channel
	 */
	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}


	/**
	 * Sets refund fee.
	 *
	 * @param refund_fee the refund fee
	 */
	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}


	/**
	 * Sets settlement refund fee.
	 *
	 * @param settlement_refund_fee the settlement refund fee
	 */
	public void setSettlement_refund_fee(String settlement_refund_fee) {
		this.settlement_refund_fee = settlement_refund_fee;
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
	 * Sets settlement total fee.
	 *
	 * @param settlement_total_fee the settlement total fee
	 */
	public void setSettlement_total_fee(String settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
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
	 * Sets cash fee.
	 *
	 * @param cash_fee the cash fee
	 */
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}


	/**
	 * Sets cash refund fee.
	 *
	 * @param cash_refund_fee the cash refund fee
	 */
	public void setCash_refund_fee(String cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}

	/**
	 * Gets coupon type 0.
	 *
	 * @return the coupon type 0
	 */
	public String getCoupon_type_0() {
		return coupon_type_0;
	}

	/**
	 * Sets coupon type 0.
	 *
	 * @param coupon_type_0 the coupon type 0
	 */
	public void setCoupon_type_0(String coupon_type_0) {
		this.coupon_type_0 = coupon_type_0;
	}

	/**
	 * Gets coupon type 1.
	 *
	 * @return the coupon type 1
	 */
	public String getCoupon_type_1() {
		return coupon_type_1;
	}

	/**
	 * Sets coupon type 1.
	 *
	 * @param coupon_type_1 the coupon type 1
	 */
	public void setCoupon_type_1(String coupon_type_1) {
		this.coupon_type_1 = coupon_type_1;
	}

	/**
	 * Gets coupon type 2.
	 *
	 * @return the coupon type 2
	 */
	public String getCoupon_type_2() {
		return coupon_type_2;
	}

	/**
	 * Sets coupon type 2.
	 *
	 * @param coupon_type_2 the coupon type 2
	 */
	public void setCoupon_type_2(String coupon_type_2) {
		this.coupon_type_2 = coupon_type_2;
	}

	/**
	 * Gets coupon refund id 0.
	 *
	 * @return the coupon refund id 0
	 */
	public String getCoupon_refund_id_0() {
		return coupon_refund_id_0;
	}

	/**
	 * Sets coupon refund id 0.
	 *
	 * @param coupon_refund_id_0 the coupon refund id 0
	 */
	public void setCoupon_refund_id_0(String coupon_refund_id_0) {
		this.coupon_refund_id_0 = coupon_refund_id_0;
	}

	/**
	 * Gets coupon refund id 1.
	 *
	 * @return the coupon refund id 1
	 */
	public String getCoupon_refund_id_1() {
		return coupon_refund_id_1;
	}

	/**
	 * Sets coupon refund id 1.
	 *
	 * @param coupon_refund_id_1 the coupon refund id 1
	 */
	public void setCoupon_refund_id_1(String coupon_refund_id_1) {
		this.coupon_refund_id_1 = coupon_refund_id_1;
	}

	/**
	 * Gets coupon refund id 2.
	 *
	 * @return the coupon refund id 2
	 */
	public String getCoupon_refund_id_2() {
		return coupon_refund_id_2;
	}

	/**
	 * Sets coupon refund id 2.
	 *
	 * @param coupon_refund_id_2 the coupon refund id 2
	 */
	public void setCoupon_refund_id_2(String coupon_refund_id_2) {
		this.coupon_refund_id_2 = coupon_refund_id_2;
	}

	/**
	 * Gets coupon refund fee 0.
	 *
	 * @return the coupon refund fee 0
	 */
	public String getCoupon_refund_fee_0() {
		return coupon_refund_fee_0;
	}

	/**
	 * Sets coupon refund fee 0.
	 *
	 * @param coupon_refund_fee_0 the coupon refund fee 0
	 */
	public void setCoupon_refund_fee_0(String coupon_refund_fee_0) {
		this.coupon_refund_fee_0 = coupon_refund_fee_0;
	}

	/**
	 * Gets coupon refund fee 1.
	 *
	 * @return the coupon refund fee 1
	 */
	public String getCoupon_refund_fee_1() {
		return coupon_refund_fee_1;
	}

	/**
	 * Sets coupon refund fee 1.
	 *
	 * @param coupon_refund_fee_1 the coupon refund fee 1
	 */
	public void setCoupon_refund_fee_1(String coupon_refund_fee_1) {
		this.coupon_refund_fee_1 = coupon_refund_fee_1;
	}

	/**
	 * Gets coupon refund fee 2.
	 *
	 * @return the coupon refund fee 2
	 */
	public String getCoupon_refund_fee_2() {
		return coupon_refund_fee_2;
	}

	/**
	 * Sets coupon refund fee 2.
	 *
	 * @param coupon_refund_fee_2 the coupon refund fee 2
	 */
	public void setCoupon_refund_fee_2(String coupon_refund_fee_2) {
		this.coupon_refund_fee_2 = coupon_refund_fee_2;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
