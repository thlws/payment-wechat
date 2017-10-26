package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * Created by HanleyTang on 2016/11/18.
 */
public class IndustryOutput {
//{"errcode":43100,"errmsg":"change template too frequently hint: [hEF8SA0617vr23]"}
//{"errcode":0,"errmsg":"ok"}
    private String errcode; // 0
    private String errmsg; // ok

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

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
