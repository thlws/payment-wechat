package org.thlws.payment.wechat.entity.request;

import org.thlws.payment.wechat.utils.JsonUtil;

/***
 * 微信退款参数对象
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class WechatRefundRequest {

	//如下为必须参数

	/**公众账号ID*/
	private String appid            ;

	/**商户号*/
	private String mch_id           ;

	/**随机字符串*/
	private String nonce_str        ;

	/**签名*/
	private String sign             ;

	/**商户退款单号*/
	private String out_refund_no    ;

	/**订单总金额*/
	private String total_fee        ;

	/**申请退款金额*/
	private String refund_fee       ;

	//transaction_id&out_trade_no二选一

	/**微信订单号*/
	private String transaction_id   ;

	/**商户订单号*/
	private String out_trade_no     ;
	
	//如下参数可选

	/**货币种类 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY*/
	private String refund_fee_type  ;

	/**退款原因*/
	private String refund_desc;

	/**
	 * 退款资金来源
	 * <pre>
	 *     仅针对老资金流商户使用 REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）
	 		REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
	 * </pre>
	 * */
	private String refund_account;

	/**子商户公众账号ID*/
	private String sub_appid;

	/**子商户号*/
	private String sub_mch_id;

	/**
	 * Instantiates a new Wechat refund request.
	 */
	public WechatRefundRequest(){}

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
	 * Gets out refund no.
	 *
	 * @return the out refund no
	 */
	public String getOut_refund_no() {
		return out_refund_no;
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
	 * Gets refund fee.
	 *
	 * @return the refund fee
	 */
	public String getRefund_fee() {
		return refund_fee;
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
	 * Gets refund fee type.
	 *
	 * @return the refund fee type
	 */
	public String getRefund_fee_type() {
		return refund_fee_type;
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
	 * Sets out refund no.
	 *
	 * @param out_refund_no the out refund no
	 */
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
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
	 * Sets refund fee.
	 *
	 * @param refund_fee the refund fee
	 */
	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
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
	 * Sets refund fee type.
	 *
	 * @param refund_fee_type the refund fee type
	 */
	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}

	/**
	 * Gets refund desc.
	 *
	 * @return the refund desc
	 */
	public String getRefund_desc() {
		return refund_desc;
	}

	/**
	 * Sets refund desc.
	 *
	 * @param refund_desc the refund desc
	 */
	public void setRefund_desc(String refund_desc) {
		this.refund_desc = refund_desc;
	}

	/**
	 * Gets refund account.
	 *
	 * @return the refund account
	 */
	public String getRefund_account() {
		return refund_account;
	}

	/**
	 * Sets refund account.
	 *
	 * @param refund_account the refund account
	 */
	public void setRefund_account(String refund_account) {
		this.refund_account = refund_account;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
