package org.thlws.payment.wechat.entity.input;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class WechatRefundInput {

	//如下为必须参数
	private String appid            ;
	private String mch_id           ;
	private String nonce_str        ;
	private String sign             ;
	private String out_refund_no    ;
	private String total_fee        ;
	private String refund_fee       ;
	private String op_user_id		;//default mch_id(商户号)
	
	//transaction_id&out_trade_no二选一
	private String transaction_id   ;
	private String out_trade_no     ;
	
	//如下参数可选
	private String refund_fee_type  ;
	private String device_info      ;

	private String sub_appid;
	private String sub_mch_id;
	
	public WechatRefundInput(){}

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

	public String getAppid() {
		return appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public String getRefund_fee_type() {
		return refund_fee_type;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getOp_user_id() {
		return op_user_id;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
