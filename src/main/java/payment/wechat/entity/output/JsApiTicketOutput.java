package payment.wechat.entity.output;

import payment.wechat.utils.JsonUtil;

import java.io.Serializable;

/**
 * Created by HanleyTang on 2016/11/15.
 */
public class JsApiTicketOutput implements Serializable {

    private String errcode;
    private String errmsg;
    private String ticket;
    private String expires_in;

    public JsApiTicketOutput() {
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

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }
}
