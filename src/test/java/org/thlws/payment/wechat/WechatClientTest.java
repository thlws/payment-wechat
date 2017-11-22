package org.thlws.payment.wechat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.*;
import org.thlws.payment.wechat.portal.client.WechatClient;
import org.thlws.payment.wechat.utils.DataUtil;
import org.thlws.payment.wechat.utils.LocalUtil;
import org.thlws.payment.wechat.utils.ZxingUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * 微信非公众号支付测试
 * Created by HanleyTang on 16/9/4.
 */
public class WechatClientTest {

    static final protected Logger log = LoggerFactory.getLogger(WechatClientTest.class);

    /**爱快购微商城[服务商,下属含子商户].微信配置 sp = service provider */
    private static final String sp_wechat_appid= "wxc475c2bd2958388e";
    private static final String sp_wechat_appsecret="f02f5eecfed86f8a3cf753697fbf3246";
    private static final String sp_wechat_mchid="1386246702";
    private static final String sp_wechat_apikey="f02f5eecfed86f8a3cf753697fbf3246";
    private static final String sp_wechat_sub_mchid="1396726602";
    private static final String sp_wechat_openid="ou9z1v4CQEJLqbIikJr7UxPmIvYQ";


    /*爱快购测试环境*/
    private static final String test_wechat_appid= "wx5f22a16d8c94dba4";
    private static final String test_wechat_appsecret="d24a3e612fca66ae28137de28916f875";
    private static final String test_wechat_mchid="1336236101";
    private static final String test_wechat_apikey="d24a3e612fca66ae28137de28916f875";


    @Test
    public  void test_unifiedOrder() throws Exception{

        UnifiedOrderInput input = new UnifiedOrderInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);

        String body = "好吃";
        input.setNonce_str(DataUtil.getRandomString(32));
        input.setBody(body);
        input.setOut_trade_no(System.currentTimeMillis()+"");
        input.setTotal_fee("1");
        input.setTrade_type("NATIVE");
        input.setNotify_url("http://www.iquickgo.com/notify4Wechat.html");
        input.setSpbill_create_ip(LocalUtil.getLocalIP());

        UnifiedOrderOutput output = WechatClient.unifiedorder(input,test_wechat_apikey);
        log.info("WechatClient.unifiedorder->output=\n"+output.toString());
        String qrcode = output.getCode_url();
        ZxingUtil.qrCode(qrcode,"png","/zone/"+input.getOut_trade_no()+".png");
        //TODO 调用查询接口，检测用户是否完成支付
    }


    /***
     * 付款
     */
    @Test
    public void test_pay(){
        log.info("微信下线[支付]测试开始-WechatClient.micropay");
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        WechatPayInput input = new WechatPayInput();
        input.setAppid(test_wechat_appid);
        input.setMch_id(test_wechat_mchid);
//        input.setSub_mch_id("1396726602");//若是子商户需设置该参数
        input.setSpbill_create_ip(LocalUtil.getLocalIP());
        input.setTotal_fee("1");
        input.setAttach("00001025104487");
        input.setOut_trade_no(DataUtil.getRandomString(32));
        input.setAuth_code("130241326448617032");
        input.setNonce_str(DataUtil.getRandomString(32));
        input.setDevice_info("device...");
        input.setBody("pay test");

        WechatPayOutput output = WechatClient.micropay(input,apiKey);
        log.info("WechatClient.micropay->output="+output.toString());
        assertNotNull(output);
    }


    /***
     * 退款
     */
    @Test
    public void test_refund(){
        String p12FilePath = "/zone/p12/1386246702.p12";//爱快购微商城p12
        log.info("微信.爱快购微商城[退款]测试开始-WechatClient.refund");
        WechatRefundInput data = new WechatRefundInput();
        data.setSub_mch_id("1396726602");//若为子商户退款需设置该参数
        String apiKey = "f02f5eecfed86f8a3cf753697fbf3246";
        data.setAppid("wxc475c2bd2958388e");
        data.setMch_id("1386246702");
        data.setTransaction_id("4007402001201611119430531609");
        data.setOut_trade_no("20160902224757");
        data.setOut_refund_no(DataUtil.getRandomString(24));
        data.setTotal_fee("1");
        data.setRefund_fee("1");
        data.setOp_user_id("1386246702");
        data.setNonce_str(DataUtil.getRandomString(32));

        WechatRefundOutput output = WechatClient.refund(data,apiKey,p12FilePath);
        log.info("WechatClient.refund->output="+output.toString());

        assertEquals(output.getReturn_code(),"SUCCESS");
    }


    /***
     * 订单查询
     */
    @Test
    public void test_orderQuery(){

        log.info("微信[订单查询]测试开始-WechatClient.orderQuery");
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        OrderQueryInput input = new OrderQueryInput();
        input.setAppid("wx5f22a16d8c94dba4");
        input.setMch_id("1336236101");
        //input.setSub_mch_id("1396726602");//若为子商户退款需设置该参数
        input.setTransaction_id("4005332001201610166835977303");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(DataUtil.getRandomString(32));
        OrderQueryOutput output = WechatClient.orderQuery(input,apiKey);
        log.info("WechatClient.orderQuery->output="+output.toString());
    }



    /***
     * 撤销订单
     */
    @Test
    public void test_reverse(){

        log.info("微信[撤销订单]测试开始-WechatClient.reverse");
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        WechatReverseInput input = new WechatReverseInput();
        input.setAppid("wx5f22a16d8c94dba4");
        input.setMch_id("1336236101");
        //input.setSub_mch_id("1396726602");//若为子商户退款需设置该参数
        input.setTransaction_id("1217752501201407033233368018");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(DataUtil.getRandomString(32));
        String p12FilePath = "/zone/p12/1336236101.p12";
        WechatReverseOutput output = WechatClient.reverse(input,apiKey,p12FilePath);

    }


    /***
     * 提交小微申请，暂未启用,未来可能移除
     *  @deprecated
     */
    public void test_postMciroMch(){

        String apiKey = "ig9PXjJ5im8o3sfb3kuIYJ4wqTvGmzQX";

        //just for  add(新增收款个人用户)
        MicroMchInput wr = new MicroMchInput();
        wr.setAppid(sp_wechat_appid);
        wr.setMch_id(sp_wechat_mchid);
        wr.setMerchant_name("翰林美食铺");
        wr.setMerchant_shortname("Hanley");
        wr.setRecipient_name("汤翰林");
        wr.setRecipient_idcardno("511381198710080079");
        wr.setRecipient_wechatid("hanleytang");
        wr.setBusiness("食品");
        wr.setMerchant_remark("hanley20160827");
        wr.setMerchant_gbaddress("310105");
        wr.setMerchant_detailaddress("昭化路505号301室");
        WechatClient.postMicroMch(wr,sp_wechat_apikey,"");

    }

    /***
     * 查询小微资料，暂未启用,未来可能移除
     * @deprecated
     */
    public void test_QueryMciro(){

        String apiKey = "ig9PXjJ5im8o3sfb3kuIYJ4wqTvGmzQX";

        //just for query
        MicroMchInput wr2 = new MicroMchInput();
        wr2.setAppid("wx5f22a16d8c94dba4");
        wr2.setMch_id("1336236101");
        wr2.setRecipient_wechatid("hanleytang");
        WechatClient.queryMicroMch(wr2,apiKey,"");
    }


}
