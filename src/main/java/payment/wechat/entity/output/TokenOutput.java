package payment.wechat.entity.output;

import payment.wechat.utils.JsonUtil;

import java.io.Serializable;

/**
 * Created by HanleyTang on 2016/11/15.
 */
public class TokenOutput implements Serializable{

    private String access_token;
    private String expires_in;

    public TokenOutput() {
    }

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
