package org.thlws.payment.wechat.entity.request;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 微信订单查询对象
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class OrderQueryRequest {

    /**公众账号ID*/
    private String appid;

    /**商户号*/
    private String mch_id;

    /**微信订单号 ,transaction_id ，out_trade_no 二选一即可*/
    private String transaction_id;

    /**商户订单号,transaction_id ，out_trade_no 二选一即可*/
    private String out_trade_no;

    /**随机字符串-32个字符内*/
    private String nonce_str;

    /**签名*/
    private String sign;

    /**子商户公众账号ID*/
    private String sub_appid;

    /**子商户号*/
    private String sub_mch_id;

    /**
     * Instantiates a new Order query request.
     */
    public OrderQueryRequest(){}

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
     * Sets appid.
     *
     * @param appid the appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
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
     * Sets mch id.
     *
     * @param mch_id the mch id
     */
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
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
     * Sets transaction id.
     *
     * @param transaction_id the transaction id
     */
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
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
     * Sets out trade no.
     *
     * @param out_trade_no the out trade no
     */
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
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
     * Sets nonce str.
     *
     * @param nonce_str the nonce str
     */
    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
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
     * Sets sign.
     *
     * @param sign the sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
