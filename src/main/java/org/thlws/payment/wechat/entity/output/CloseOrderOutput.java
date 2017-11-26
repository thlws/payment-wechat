package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 关闭订单结果对象 <br>
 *
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3">https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3</a> Created by HanleyTang on 2017/3/15.
 */
public class CloseOrderOutput {

    /**返回状态码*/
    private String return_code   ;

    /**业务结果描述*/
    private String return_msg    ;

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

    /**错误代码*/
    private String err_code      ;

    /**错误代码描述*/
    private String err_code_des  ;

    /**子公众账号ID*/
    private String sub_appid     ;

    /**业务结果*/
    private String result_code	 ;

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

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
