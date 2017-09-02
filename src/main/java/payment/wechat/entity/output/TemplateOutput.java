package payment.wechat.entity.output;

import payment.wechat.utils.JsonUtil;

import java.io.Serializable;

/**
 * Created by HanleyTang on 2016/11/18.
 */
public class TemplateOutput implements Serializable{

    private String errcode;//0 表示成功
    private String errmsg;
    private String template_id;

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
}
