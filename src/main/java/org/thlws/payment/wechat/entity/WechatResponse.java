package org.thlws.payment.wechat.entity;

import cn.hutool.core.util.StrUtil;

import java.io.Serializable;

/***
 * API请求结果
 */
public class WechatResponse implements Serializable {

    /**返回状态码*/
    private String return_code;

    /**返回信息*/
    private String return_msg ;

    /**业务结果*/
    private String result_code;

    /**错误代码*/
    private String err_code;

    /**错误代码描述*/
    private String err_code_des;


    public String getMessage() {
        String message = isSuccess() ? return_msg:err_code+","+err_code_des;
        return message;
    }


    public boolean isSuccess() {
        return StrUtil.equalsIgnoreCase(return_code,result_code) && StrUtil.equals("SUCCESS",result_code);
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
     * Gets result code.
     *
     * @return the result code
     */
    public String getResult_code() {
        return result_code;
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
     * Sets result code.
     *
     * @param result_code the result code
     */
    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }


}
