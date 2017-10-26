package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 统一下单返回POJO
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class UnifiedOrderOutput {
	
	private String return_code     ;
	private String return_msg      ;
	private String appid           ;
	private String mch_id          ;
	private String nonce_str       ;
	private String sign            ;
	private String result_code     ;
	private String prepay_id       ;
	private String trade_type      ;

	private String device_info;
	private String err_code;
	private String err_code_des;
    private String code_url;
	private String sub_appid;
	private String sub_mch_id;

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}

	public UnifiedOrderOutput() {
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

	public String getCode_url() {
		return code_url;
	}

	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

	public String getReturn_code() {
		return return_code;
	}

	public String getReturn_msg() {
		return return_msg;
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

	public String getResult_code() {
		return result_code;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
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

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}


	
	
}
