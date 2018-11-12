package org.thlws.payment.wechat.entity.response;

import org.thlws.payment.wechat.entity.WechatResponse;
import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 关闭订单结果对象 <br>
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3">关闭订单结果参数</a>
 */
public class CloseOrderResponse extends WechatResponse {

    /**公众账号ID*/
    private String appid         ;

    /**商户号*/
    private String mch_id        ;

    /**子商户号*/
    private String sub_mch_id    ;

    /**随机字符串*/
    private String nonce_str     ;

    /**签名*/
    private String sign          ;

    /**子公众账号ID*/
    private String sub_appid     ;


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


    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
