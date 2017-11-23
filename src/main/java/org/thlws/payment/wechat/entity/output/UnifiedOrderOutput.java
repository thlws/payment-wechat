package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/***
 * 微信统一下单结果对象
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class UnifiedOrderOutput {

	/**返回状态码*/
	private String return_code     ;

	/**返回信息*/
	private String return_msg      ;

	/**公众账号ID*/
	private String appid           ;

	/**商户号*/
	private String mch_id          ;

	/**随机字符串*/
	private String nonce_str       ;

	/**签名*/
	private String sign            ;

	/**业务结果*/
	private String result_code     ;

	/**预支付交易会话标识*/
	private String prepay_id       ;

	/**交易类型 JSAPI，NATIVE，APP*/
	private String trade_type      ;

	/**设备号	*/
	private String device_info;

	/**错误代码	*/
	private String err_code;

	/**错误代码描述	*/
	private String err_code_des;

	/**二维码链接,trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付*/
    private String code_url;

	/**子商户公众账号ID*/
	private String sub_appid;

	/**子商户号	*/
	private String sub_mch_id;

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}

	/**
	 * Instantiates a new Unified order output.
	 */
	public UnifiedOrderOutput() {
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
	 * Gets code url.
	 *
	 * @return the code url
	 */
	public String getCode_url() {
		return code_url;
	}

	/**
	 * Sets code url.
	 *
	 * @param code_url the code url
	 */
	public void setCode_url(String code_url) {
		this.code_url = code_url;
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
	 * Gets prepay id.
	 *
	 * @return the prepay id
	 */
	public String getPrepay_id() {
		return prepay_id;
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
	 * Sets prepay id.
	 *
	 * @param prepay_id the prepay id
	 */
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	/**
	 * Sets trade type.
	 *
	 * @param trade_type the trade type
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}


	
	
}
