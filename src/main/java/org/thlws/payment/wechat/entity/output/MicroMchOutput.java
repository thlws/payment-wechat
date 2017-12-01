package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * The type Micro mch output.
 *
 * @author Hanley Tang | hanley@hanley.cn
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

	/**
	 * Instantiates a new Micro mch output.
	 */
	public MicroMchOutput(){}

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
	 * Gets mch id.
	 *
	 * @return the mch id
	 */
	public String getMch_id() {
		return mch_id;
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
	 * Gets micro mch id.
	 *
	 * @return the micro mch id
	 */
	public String getMicro_mch_id() {
		return micro_mch_id;
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
	 * Sets mch id.
	 *
	 * @param mch_id the mch id
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
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
	 * Sets micro mch id.
	 *
	 * @param micro_mch_id the micro mch id
	 */
	public void setMicro_mch_id(String micro_mch_id) {
		this.micro_mch_id = micro_mch_id;
	}
	
	
}
