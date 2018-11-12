package org.thlws.payment.wechat;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.thlws.payment.wechat.entity.response.mp.OauthTokenResponse;
import org.thlws.payment.wechat.entity.response.mp.UserInfoResponse;
import org.thlws.payment.wechat.client.WechatMpClient;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

/***
 * 微信公众号支付测试
 * Created by HanleyTang on 16/9/4.
 */
public class WechatMpClientTest {

    private static final Log log = LogFactory.get();

    /***
     * 获取OauthaccessToken
     */
    public void test_ObtainOauthToken() {
        try {
            Map<String, Object> mapToken = new HashMap<String, Object>();
            String appId = "wx5f22a16d8c94dba4";
            String appSecret = "d24a3e612fca66ae28137de28916f875";
            String code = "11111";
            mapToken.put("appid", appId);
            mapToken.put("secret", appSecret);
            mapToken.put("code", code);
            mapToken.put("grant_type", "authorization_code");
            OauthTokenResponse response = WechatMpClient.obtainOauthAccessToken(mapToken);
            System.out.println("openid="+response.getOpenid());
            assertNotNull(response.getOpenid());
        } catch (Exception e) {
            log.error(e);
        }
    }

    /***
     * 刷新OauthToken
     */
    public void test_RefreshOauthToken() {
        try {
            Map<String, Object> mapToken = new HashMap<String, Object>();
            String appId = "wx5f22a16d8c94dba4";
            mapToken.put("appid", appId);
            mapToken.put("refresh_token", "填写通过access_token获取到的refresh_token参数");
            mapToken.put("grant_type", "refresh_token");
            OauthTokenResponse response = WechatMpClient.refreshOauthAccessToken(mapToken);
            assertNotNull(response.getAccess_token());
        } catch (Exception e) {
            log.error(e);
        }
    }

    /***
     * 获取微信用户信息
     */
    public void test_ObtainUserInfo() {
        try {
            Map<String, Object> userInfoMap = new HashMap<String, Object>();
            String accessToken = "";
            String openId = "";
            userInfoMap.put("access_token", accessToken);
            userInfoMap.put("openid", openId);
            userInfoMap.put("lang", "zh_CN");
            UserInfoResponse response = WechatMpClient.obtainUserInfo(userInfoMap);
            assertNotNull(response.getOpenid());
        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * 生成微信URL[包含回调地址]
     * 生成URL后，引导用户点击，微信会向回调地址中返回code，可用于获取用户OpenId
     */
    public void test_BuildWechatURL() {
        String appId = "wx5f22a16d8c94dba4";
        String scope = "snsapi_base";
        /***
         * 需在getcode.html中取得code参数
         * <code>String code = request.getParameter("code");</code>
         */
        String callback = "http://www.thlws.com/wechat/callback/getcode.html";
        String bizData = "";//对应微信state参数，微信会原样返回
        String url = WechatMpClient.generateWechatUrl(appId, scope, callback, bizData);
        assertNotNull(url);
    }

    /***
     * 检测token是否有效
     */
    public void test_IsvalidOauthToken() {
        try {
            Map<String, Object> mapToken = new HashMap<String, Object>();
            String access_token = "your token";
            String open_id = "your openid";
            mapToken.put("access_token", access_token);
            mapToken.put("openid", "");
            boolean flag = WechatMpClient.IsvalidOauthAccessToken(mapToken);
            assertTrue(flag);
        } catch (Exception e) {
            log.error(e);
        }
    }

}
