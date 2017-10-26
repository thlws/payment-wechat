package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class MicroMchOutput {

	private String return_code ;	//以下字段在 return_code 为 SUCCESS 的时候有返回
	private String return_msg  ;
	private String mch_id      ;
	private String sign        ;
	private String result_code ;
	private String err_code    ;
	private String err_code_des;
	private String micro_mch_id;	//result_code 为 SUCCESS 的时候有返回

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}

	public MicroMchOutput(){}

	public String getReturn_code() {
		return return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public String getMch_id() {
		return mch_id;
	}

	public String getSign() {
		return sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public String getMicro_mch_id() {
		return micro_mch_id;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public void setMicro_mch_id(String micro_mch_id) {
		this.micro_mch_id = micro_mch_id;
	}
	
	
}
