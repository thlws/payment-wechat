package org.thlws.payment.wechat.entity.response;

import org.thlws.payment.wechat.entity.WechatResponse;
import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * The type Micro mch response.
 *
 * @author Hanley Tang | hanley@hanley.cn
 * @version 1.0
 */
public class MicroMchResponse extends WechatResponse {

	private String mch_id      ;
	private String sign        ;
	private String micro_mch_id;	//result_code 为 SUCCESS 的时候有返回

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}

	/**
	 * Instantiates a new Micro mch response.
	 */
	public MicroMchResponse(){}


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
	 * Gets micro mch id.
	 *
	 * @return the micro mch id
	 */
	public String getMicro_mch_id() {
		return micro_mch_id;
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
	 * Sets micro mch id.
	 *
	 * @param micro_mch_id the micro mch id
	 */
	public void setMicro_mch_id(String micro_mch_id) {
		this.micro_mch_id = micro_mch_id;
	}
	
	
}
