package org.thlws.payment.wechat.entity.request;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * Created by HanleyTang on 2018/11/4
 * 根据付款码查询 OpenId pojo
 *
 * @author Hanley[hanley @thlws.com]
 * @version 1.0
 */
public class OpenidQueryRequest {

    /**公众账号ID*/
    private String appid;

    /**商户号*/
    private String mch_id;

    /**随机字符串-32个字符内*/
    private String nonce_str;

    /**
     * 条码或者二维码信息
     */
    private String auth_code;

    /**签名*/
    private String sign;


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
     * Gets auth code.
     *
     * @return the auth code
     */
    public String getAuth_code() {
        return auth_code;
    }

    /**
     * Sets auth code.
     *
     * @param auth_code the auth code
     */
    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
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


