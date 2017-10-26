package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * Created by HanleyTang on 2016/11/18.
 */
public class SendDataOutput {

    //{"errcode":0,"errmsg":"ok","msgid":414569352}

    private String errcode;
    private String errmsg;
    private String msgid;

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

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
}
