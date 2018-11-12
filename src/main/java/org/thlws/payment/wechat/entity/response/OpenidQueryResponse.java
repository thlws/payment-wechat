package org.thlws.payment.wechat.entity.response;

import org.thlws.payment.wechat.entity.WechatResponse;
import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * Created by HanleyTang on 2018/11/4
 * 根据付款码查询 OpenId pojo 结果对象
 *
 * @author Hanley[hanley @thlws.com]
 * @version 1.0
 */
public class OpenidQueryResponse extends WechatResponse {


    /**公众账号ID*/
    private String appid         ;

    /**商户号*/
    private String mch_id        ;

    /**随机字符串-32个字符内*/
    private String nonce_str     ;

    /**签名*/
    private String sign          ;

    private String openid        ;

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
     * Gets openid.
     *
     * @return the openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * Sets openid.
     *
     * @param openid the openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }


    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
