package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

import java.util.List;

/***
 * 拉取用户信息(需scope为 snsapi_userinfo) Response POJO
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class UserInfoOutput {

	private String openid         ;
	private String nickname       ;
	private String sex            ;
	private String province       ;
	private String city           ;
	private String country        ;
	private String headimgurl     ;
	private String unionid        ;
	private List<String> privilege;//用户特权信息，json数组，如微信沃卡用户为（chinaunicom）

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}

	public UserInfoOutput(){}

	public String getOpenid() {
		return openid;
	}

	public String getNickname() {
		return nickname;
	}

	public String getSex() {
		return sex;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public String getUnionid() {
		return unionid;
	}

	public List<String> getPrivilege() {
		return privilege;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public void setPrivilege(List<String> privilege) {
		this.privilege = privilege;
	}
	
	
	
}
