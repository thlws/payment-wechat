package org.thlws.payment.wechat;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.core.util.NetUtil;
import org.junit.Test;

import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.*;
import org.thlws.payment.wechat.portal.client.WechatClient;
import org.thlws.payment.wechat.utils.ThlwsBeanUtil;
import org.thlws.payment.wechat.utils.ZxingUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * 微信非公众号支付测试<br>
 * <h3>特别注意</h3>
 * 项目中提供的微信测试账户，仅用于接口功能测试，请勿用作其他用途。
 * Created by HanleyTang on 16/9/4.
 */
public class WechatClientTest {

    private static final Log log = LogFactory.get();

    /**服务商[下属含子商户].微信配置 sp = service provider */
//    private static final String sp_wechat_appid= "wxc475c2bd2958388e";
//    private static final String sp_wechat_appsecret="f02f5eecfed86f8a3cf753697fbf3246";
//    private static final String sp_wechat_mchid="1386246702";
//    private static final String sp_wechat_apikey="f02f5eecfed86f8a3cf753697fbf3246";
//    private static final String sp_wechat_sub_mchid="1490071962";//1490071962   1396726602
//    private static final String sp_wechat_openid="ou9z1v4CQEJLqbIikJr7UxPmIvYQ";


    /*普通商户*/
    private static final String test_wechat_appid= "wx5f22a16d8c94dba4";
    private static final String test_wechat_appsecret="d24a3e612fca66ae28137de28916f875";
    private static final String test_wechat_mchid="1336236101";
    private static final String test_wechat_apikey="d24a3e612fca66ae28137de28916f875";


    private static final String sp_wechat_appid= "wxa3f3406c0b04a601";
    private static final String sp_wechat_appsecret="04303a8acc9786ddac6458d401ca764f";
    private static final String sp_wechat_mchid="1511132631";
    private static final String sp_wechat_apikey="04303a8acc9786ddac6458d401ca764f";
    private static final String sp_wechat_sub_mchid="1517927831";//1490071962   1396726602
//    private static final String sp_wechat_openid="ou9z1v4CQEJLqbIikJr7UxPmIvYQ";

//1258 679f5770ab7800faef5663e160e5a510
//    private static final String test_wechat_appid= "wx2aea382951e33ca4";
//    private static final String test_wechat_appsecret="d55fc95fa77868bc1ca9f447f8872eb2";
//    private static final String test_wechat_mchid="1297038501";
//    private static final String test_wechat_apikey="679f5770ab7800faef5663e160e5a510";


    /***
     * 扫码支付 & 公众支付 时必须调用该接口
     * @throws Exception
     */
    @Test
    public  void test_unifiedOrder() throws Exception{

        UnifiedOrderInput input = new UnifiedOrderInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);

        /*普通模式无需设置,子商户需设置子商户号,小微模式固定填1000077001*/
        //input.setSub_mch_id("1396726602");

         /*open_id 与 sub_openid 择其一即可,具体传值方式以参数说明为准*/
        //input.setOpenid("用户在appid下用户标识");

        /*open_id 与 sub_openid 择其一即可,具体传值方式以参数说明为准*/
        //input.setSub_openid("用户在sub_appid下用户标识");
        String body = "动态二维码支付测试";
        input.setNonce_str(ThlwsBeanUtil.getRandomString(32));
        input.setBody(body);
        input.setOut_trade_no(System.currentTimeMillis()+"");
        input.setTotal_fee("1");
        input.setTrade_type("NATIVE");
        input.setNotify_url("http://www.thlws.com/notify4Wechat.html");
        input.setSpbill_create_ip(NetUtil.getLocalhostStr());

        UnifiedOrderOutput output = WechatClient.unifiedorder(input,test_wechat_apikey);
        String qrcode = output.getCode_url();
//        assertNotNull(qrcode);
        //生成支付二维码，供用户扫码支付
        ZxingUtil.qrCode(qrcode,"png","/zone/qrcode/"+input.getOut_trade_no()+".png");
        //TODO 调用查询接口，检测用户是否完成支付
    }


    /***
     * 微信付款，二维码刷卡支付
     */
    @Test
    public void test_pay(){
        log.info("微信下线[支付]测试开始-WechatClient.micropay");
        String apiKey = test_wechat_apikey;
        WechatPayInput input = new WechatPayInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);

        /*普通模式无需设置,子商户需设置子商户号*/
//        input.setSub_mch_id(sp_wechat_sub_mchid);

        input.setSpbill_create_ip(NetUtil.getLocalhostStr());
        input.setTotal_fee("1");
        input.setAttach("00001025104487");
        input.setOut_trade_no(ThlwsBeanUtil.getRandomString(32));
        input.setAuth_code("134594349892009342");
        input.setNonce_str(ThlwsBeanUtil.getRandomString(32));
        input.setDevice_info("device...");
        input.setBody("pay test");

        WechatPayOutput output = WechatClient.micropay(input,apiKey);
        assertNotNull(output);
    }


    /***
     * 退款
     */
    @Test
    public void test_refund(){

        String p12FilePath = "/zone/p12/1336236101.p12";//
        log.info("微信[退款]测试开始-WechatClient.refund");
        WechatRefundInput data = new WechatRefundInput();
        //data.setSub_mch_id(sp_wechat_sub_mchid);//若为子商户退款需设置该参数
//        data.setSub_mch_id("1490071962");//若为子商户退款需设置该参数

        String apiKey = test_wechat_apikey;
        data.setAppid(test_wechat_appid);
        data.setMch_id(test_wechat_mchid);
//        data.setTransaction_id("4200000047201711185443296984");
        data.setOut_trade_no("ldk9ma68zetembtuq2a6ptwozsklzlie");
        data.setOut_refund_no(ThlwsBeanUtil.getRandomString(24));
        data.setTotal_fee("10");
        data.setRefund_fee("5");
        data.setNonce_str(ThlwsBeanUtil.getRandomString(32));

        WechatRefundOutput output = WechatClient.refund(data,apiKey,p12FilePath);
        assertEquals(output.getReturn_code(),"SUCCESS");
    }


    /***
     * 订单查询
     */
    @Test
    public void test_orderQuery(){

        log.info("微信[订单查询]测试开始-WechatClient.orderQuery");
        OrderQueryInput input = new OrderQueryInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);
        //input.setSub_mch_id("1396726602");//若为子商户退款需设置该参数
        input.setTransaction_id("4005332001201610166835977303");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(ThlwsBeanUtil.getRandomString(32));
        OrderQueryOutput output = WechatClient.orderQuery(input,test_wechat_apikey);
        assertNotNull(output.getOpenid());

    }



    /***
     * 撤销订单
     */
    @Test
    public void test_reverse(){

        log.info("微信[撤销订单]测试开始-WechatClient.reverse");
        WechatReverseInput input = new WechatReverseInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);
        //input.setSub_mch_id("1396726602");//若为子商户退款需设置该参数
        input.setTransaction_id("1217752501201407033233368018");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(ThlwsBeanUtil.getRandomString(32));
        String p12FilePath = "/zone/p12/1336236101.p12";
        WechatReverseOutput output = WechatClient.reverse(input,test_wechat_apikey,p12FilePath);
        assertNotNull(output);
    }

    @Test
    public void test_closeOrder(){

        CloseOrderInput input = new CloseOrderInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);
        //input.setSub_mch_id("1396726602");//若为子商户退款需设置该参数
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(ThlwsBeanUtil.getRandomString(32));
        CloseOrderOutput output = WechatClient.closeOrder(input,test_wechat_apikey);
        assertNotNull(output);
    }


    /***
     * 提交小微申请-个人微信号实现收款功能
     * 服务商模式下，申请个人微信收款码,该模式下每日有收款限额，并且不支持退款。
     */
    @Test
    public void test_postMciroMch(){

        String p12FilePath = "/zone/p12/1386246702.p12";
        //just for  add(新增收款个人用户)
        MicroMchInput wr = new MicroMchInput();
        wr.setAppid(sp_wechat_appid);
        wr.setMch_id(sp_wechat_mchid);
        wr.setMerchant_name("THLWS");
        wr.setMerchant_shortname("Hanley");
        wr.setRecipient_name("汤翰林");
        wr.setRecipient_idcardno("511381198710080079");
        wr.setRecipient_wechatid("hanleytang");
        wr.setBusiness("收款");
        wr.setMerchant_remark("hanley20160827");
        wr.setMerchant_gbaddress("310105");
        wr.setMerchant_detailaddress("昭化路505号301室");
        MicroMchOutput output = WechatClient.postMicroMch(wr,sp_wechat_apikey,p12FilePath);
        assertNotNull(output);
    }

    /***
     * 查询小微资料-查询个人微信收款资料
     * 服务商下查询个人收款账户
     */
    @Test
    public void test_QueryMciro(){

        String p12FilePath = "/zone/p12/1386246702.p12";
        //just for query
        MicroMchInput wr2 = new MicroMchInput();
        wr2.setAppid(sp_wechat_appid);
        wr2.setMch_id(sp_wechat_mchid);
        wr2.setRecipient_wechatid("hanleytang");
        String result = WechatClient.queryMicroMch(wr2,sp_wechat_apikey,p12FilePath);
        assertNotNull(result);
    }


    @Test
    public void test_openidQuery(){

        OpenidQueryInput input = new OpenidQueryInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);
        input.setAuth_code("134599863674410654");
        input.setNonce_str(ThlwsBeanUtil.getRandomString(32));

        OpenidQueryOutput output = WechatClient.openidQuery(input, test_wechat_apikey);
        assertNotNull(output);
    }

}
