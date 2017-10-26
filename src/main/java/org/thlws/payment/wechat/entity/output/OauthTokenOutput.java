package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * Oauth access_token & refresh_token Response POJO
 * 此为Oauth方式得Token,非普通方式token
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class OauthTokenOutput {

	private String access_token    ;
	private String expires_in      ;//access_token接口调用凭证超时时间，单位（秒）
	private String refresh_token   ;
	private String openid          ;
	private String scope           ;
	private String unionid         ;
	
	private OauthTokenOutput(){}

	public String getAccess_token() {
		return access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public String getScope() {
		return scope;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
