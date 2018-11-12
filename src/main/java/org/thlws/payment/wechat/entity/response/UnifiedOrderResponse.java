package org.thlws.payment.wechat.entity.response;

import org.thlws.payment.wechat.entity.WechatResponse;
import org.thlws.payment.wechat.utils.JsonUtil;

/***
 * 微信统一下单结果对象
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class UnifiedOrderResponse  extends WechatResponse {

	/**公众账号ID*/
	private String appid           ;

	/**商户号*/
	private String mch_id          ;

	/**随机字符串*/
	private String nonce_str       ;

	/**签名*/
	private String sign            ;

	/**预支付交易会话标识*/
	private String prepay_id       ;

	/**交易类型 JSAPI，NATIVE，APP*/
	private String trade_type      ;

	/**设备号	*/
	private String device_info;

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
	 * Instantiates a new Unified order response.
	 */
	public UnifiedOrderResponse() {
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
