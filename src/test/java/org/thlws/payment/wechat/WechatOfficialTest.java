package org.thlws.payment.wechat;

import junit.framework.TestCase;
import org.apache.commons.lang.StringUtils;
import org.thlws.payment.wechat.entity.output.OauthTokenOutput;
import org.thlws.payment.wechat.entity.output.UserInfoOutput;
import org.thlws.payment.wechat.portal.official.WechatOfficial;

import java.util.HashMap;
import java.util.Map;

/***
 * 微信公众号支付测试
 * Created by HanleyTang on 16/9/4.
 */
public class WechatOfficialTest extends TestCase {


    /***
     * 获取OauthaccessToken
     */
    public void testObtainOauthToken() {
        Map<String, Object> mapToken = new HashMap<String, Object>();
        String appId = "wx5f22a16d8c94dba4";
        String appSecret = "d24a3e612fca66ae28137de28916f875";
        String code = "11111";
        mapToken.put("appid", appId);
        mapToken.put("secret", appSecret);
        mapToken.put("code", code);
        mapToken.put("grant_type", "authorization_code");
        OauthTokenOutput output = WechatOfficial.obtainOauthAccessToken(mapToken);
       // assertEquals(output.getAccess_token() != null, true);
    }

    /***
     * 刷新OauthToken
     */
    public void testRefreshOauthToken() {
        Map<String, Object> mapToken = new HashMap<String, Object>();
        String appId = "wx5f22a16d8c94dba4";
        mapToken.put("appid", appId);
        mapToken.put("refresh_token", "填写通过access_token获取到的refresh_token参数");
        mapToken.put("grant_type", "refresh_token");
        OauthTokenOutput output = WechatOfficial.refreshOauthAccessToken(mapToken);
        //assertEquals(output.getAccess_token() != null, true);
    }

    /***
     * 获取微信用户信息
     */
    public void testObtainUserInfo() {
        Map<String, Object> userInfoMap = new HashMap<String, Object>();
        String accessToken = "";
        String openId = "";
        userInfoMap.put("access_token", accessToken);
        userInfoMap.put("openid", openId);
        userInfoMap.put("lang", "zh_CN");
        UserInfoOutput output = WechatOfficial.obtainUserInfo(userInfoMap);
        assertEquals(StringUtils.isNotEmpty(output.getOpenid()), true);
    }

    /**
     * 生成微信URL[包含回调地址]
     */
    public void testBuildWechatURL() {
        String appId = "wx5f22a16d8c94dba4";
        String scope = "snsapi_base";
        String callback = "";
        String bizData = "";
        String url = WechatOfficial.generateWechatUrl(appId, scope, callback, bizData);
        System.out.println(url);
    }

    /***
     * 检测token是否有效
     */
    public void testIsvalidOauthToken() {
        Map<String, Object> mapToken = new HashMap<String, Object>();
//       mapToken.put("access_token", access_token);
//       mapToken.put("openid", "");
        boolean flag = WechatOfficial.IsvalidOauthAccessToken(mapToken);
        System.out.println(flag);
       // assertEquals(flag, true);
    }

    /***
     * 退款 同WechatClientTest.testRefund()
     */
    public void testRefund() {

    }


    /***
     * 退款(特约商户) 同同WechatClientTest.testRefund4SubMch()
     */
    public void testRefund4SubMch() {

    }
}