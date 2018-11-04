package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * Created by HanleyTang on 2018/11/4
 * 根据付款码查询 OpenId pojo 结果对象
 *
 * @author Hanley[hanley @thlws.com]
 * @version 1.0
 */
public class OpenidQueryOutput {


    /**返回状态码*/
    private String return_code   ;

    /**业务结果描述*/
    private String return_msg    ;

    /**公众账号ID*/
    private String appid         ;

    /**商户号*/
    private String mch_id        ;

    /**随机字符串-32个字符内*/
    private String nonce_str     ;

    /**签名*/
    private String sign          ;

    /**业务结果*/
    private String result_code	 ;

    /**错误代码*/
    private String err_code      ;

    private String openid        ;


    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    private String err_code_des ;

    /**
     * Gets return code.
     *
     * @return the return code
     */
    public String getReturn_code() {
        return return_code;
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
     * Gets return msg.
     *
     * @return the return msg
     */
    public String getReturn_msg() {
        return return_msg;
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
     * Gets result code.
     *
     * @return the result code
     */
    public String getResult_code() {
        return result_code;
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
