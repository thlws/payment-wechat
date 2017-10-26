package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 微信支付异步通知返回POJO
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class NotifyOutput {

	private String return_code     ;
	private String return_msg      ;
	private String appid           ;
	private String mch_id          ;
	private String nonce_str       ;
	private String sign            ;
	private String result_code     ;
	private String openid          ;
	private String trade_type      ;
	private String is_subscribe		;
	private String bank_type;
	private String total_fee;
	private String cash_fee;
	private String transaction_id;
	private String out_trade_no;
	private String time_end;



	private String device_info;
	private String err_code;
	private String err_code_des;
	private String sub_appid;
	private String sub_mch_id;
	private String sub_openid;
	private String sub_is_subscribe;
	private String fee_type;
	private String cash_fee_type;
	private String coupon_fee;
	private String coupon_count;
//	private String coupon_id_n;// spec
//	private String coupon_fee_n;//spec
	private String attach;

    private String coupon_fee_0;
	private String coupon_fee_1;
	private String coupon_fee_2;

	public String getCoupon_fee_0() {
		return coupon_fee_0;
	}

	public void setCoupon_fee_0(String coupon_fee_0) {
		this.coupon_fee_0 = coupon_fee_0;
	}

	public String getCoupon_fee_1() {
		return coupon_fee_1;
	}

	public void setCoupon_fee_1(String coupon_fee_1) {
		this.coupon_fee_1 = coupon_fee_1;
	}

	public String getCoupon_fee_2() {
		return coupon_fee_2;
	}

	public void setCoupon_fee_2(String coupon_fee_2) {
		this.coupon_fee_2 = coupon_fee_2;
	}

	public String getCoupon_id_0() {
		return coupon_id_0;
	}

	public void setCoupon_id_0(String coupon_id_0) {
		this.coupon_id_0 = coupon_id_0;
	}

	public String getCoupon_id_1() {
		return coupon_id_1;
	}

	public void setCoupon_id_1(String coupon_id_1) {
		this.coupon_id_1 = coupon_id_1;
	}

	public String getCoupon_id_2() {
		return coupon_id_2;
	}

	public void setCoupon_id_2(String coupon_id_2) {
		this.coupon_id_2 = coupon_id_2;
	}

	private String coupon_id_0;
	private String coupon_id_1;
	private String coupon_id_2;




	public NotifyOutput() {
	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getSub_is_subscribe() {
		return sub_is_subscribe;
	}

	public void setSub_is_subscribe(String sub_is_subscribe) {
		this.sub_is_subscribe = sub_is_subscribe;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public String getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public String getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(String coupon_count) {
		this.coupon_count = coupon_count;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
