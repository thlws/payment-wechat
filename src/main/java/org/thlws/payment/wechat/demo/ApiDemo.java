package org.thlws.payment.wechat.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.*;
import org.thlws.payment.wechat.portal.client.WechatClient;
import org.thlws.payment.wechat.utils.DataUtil;
import org.thlws.payment.wechat.utils.LocalUtil;
import org.thlws.payment.wechat.utils.ZxingUtil;

/**
 * Created by HanleyTang on 2017/1/4.
 */
public class ApiDemo {

    static final protected Logger log = LoggerFactory.getLogger(ApiDemo.class);


    /**爱快购微商城[服务商,下属含子商户].微信配置*/
    private static final String igo_wechat_appid= "wxc475c2bd2958388e";
    private static final String igo_wechat_appsecret="f02f5eecfed86f8a3cf753697fbf3246";
    private static final String igo_wechat_mchid="1386246702";
    private static final String igo_wechat_apikey="f02f5eecfed86f8a3cf753697fbf3246";
    private static final String igo_wechat_sub_mchid="1396726602";
    private static final String igo_wechat_openid="ou9z1v4CQEJLqbIikJr7UxPmIvYQ";


    /*爱快购测试环境*/
    private static final String test_wechat_appid= "wx5f22a16d8c94dba4";
    private static final String test_wechat_appsecret="d24a3e612fca66ae28137de28916f875";
    private static final String test_wechat_mchid="1336236101";
    private static final String test_wechat_apikey="d24a3e612fca66ae28137de28916f875";

    //上海音嘉网络科技有限公司 官网
    private static final String enjar_wechat_appid="wxc49f6e4fb3a6fdaa";
    private static final String enjar_wechat_appsecret="715824d3b921dbb04e19141e6c1673d1";
    private static final String enjar_wechat_mchid="1386784702";
    private static final String enjar_wechat_apikey="715824d3b921dbb04e19141e6c1673d1";

    //翰林爱快购
    private static final String hanley_wechat_appid = "wx5f22a16d8c94dba4";
    private static final String hanley_wechat_appsecret="d24a3e612fca66ae28137de28916f875";
    private static final String hanley_wechat_mchid="1336236101";
    private static final String hanley_wechat_apikey="d24a3e612fca66ae28137de28916f875";
    private static final String hanley_wechat_openid = "o2nMlwuj_cHFBcNDfPkpufta80KU";

    	static String p12FilePath = "/zone/p12/1336236101.p12";
//    static String p12FilePath = "c:/1386246702.p12";

    public static void main(String[] args) throws Exception{
//        testPay();
//        testQuery();
        testRefund();
//        testReverse();
//        testUnifiedOrder();
//        testCloseOrder();
//        test_postMicroMch();
//        test_QueryMicroMch();
    }


    public static  void testPay(){
        log.info("微信下线[支付]测试开始-WechatClient.micropay");
        WechatPayInput input = new WechatPayInput();
        input.setSub_mch_id(igo_wechat_sub_mchid);
        input.setAppid(igo_wechat_appid);
        input.setMch_id(igo_wechat_mchid);
        input.setSpbill_create_ip(LocalUtil.getLocalIP());
        input.setTotal_fee("1");
        input.setAttach("00001025104487");
        input.setOut_trade_no(DataUtil.getRandomString(32));
        input.setAuth_code("130241326448617032");
        input.setNonce_str(DataUtil.getRandomString(32));
        input.setDevice_info("device...");
        input.setBody("pay test");

        WechatPayOutput output = WechatClient.micropay(input,igo_wechat_apikey);
        log.info("WechatClient.micropay->output="+output.toString());
    }


    public static  void testRefund(){
        log.info("微信.爱快购微商城[退款]测试开始-WechatClient.refund");
        WechatRefundInput data = new WechatRefundInput();
//        data.setSub_mch_id(igo_wechat_sub_mchid);
        data.setAppid(test_wechat_appid);
        data.setMch_id(test_wechat_mchid);
        data.setTransaction_id("4200000010201710250277817560");
//        data.setOut_trade_no("20160902224757");
        data.setOut_refund_no(DataUtil.getRandomString(10));
        data.setTotal_fee("1");
        data.setRefund_fee("1");
        data.setOp_user_id("1386246702");
        data.setNonce_str(DataUtil.getRandomString(32));

        WechatRefundOutput output = WechatClient.refund(data,test_wechat_apikey,p12FilePath);
        log.info("WechatClient.refund->output="+output.toString());
    }


    public static void testQuery(){

        log.info("微信[订单查询]测试开始-WechatClient.orderQuery");
        OrderQueryInput input = new OrderQueryInput();
        input.setAppid(igo_wechat_appid);
        input.setMch_id(igo_wechat_mchid);
        input.setSub_mch_id("1482411282");
//        input.setSub_mch_id("1000077001");
        input.setTransaction_id("4010082001201706297965905753");
//        input.setOut_trade_no("1127710000021003631");
        input.setNonce_str(DataUtil.getRandomString(32));
        OrderQueryOutput output = WechatClient.orderQuery(input,igo_wechat_apikey);
        log.info("WechatClient.orderQuery->output="+output.toString());
    }


    public static void testReverse(){

        log.info("微信[撤销订单]测试开始-WechatClient.reverse");
        WechatReverseInput input = new WechatReverseInput();
        input.setAppid(igo_wechat_appid);
        input.setMch_id(igo_wechat_mchid);
        input.setTransaction_id("1217752501201407033233368018");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(DataUtil.getRandomString(32));
        input.setSub_mch_id(igo_wechat_sub_mchid);
        WechatReverseOutput output = WechatClient.reverse(input,igo_wechat_apikey,p12FilePath);
        log.info("WechatClient.reverse->output="+output.toString());
    }


    public static void testUnifiedOrder() throws Exception{
        log.info("testUnifiedOrder......");
        UnifiedOrderInput input = new UnifiedOrderInput();
        input.setAppid(igo_wechat_appid);
        input.setMch_id(igo_wechat_mchid);
        input.setSub_mch_id("1000077001");
        //input.setOpenid("ou9z1v2bZys_Ef2pMUWT7edJNiCk");

//        input.setAppid(hanley_wechat_appid);
//        input.setMch_id(hanley_wechat_mchid);
//        input.setOpenid(hanley_wechat_openid);

        String body = "中文会乱码吗";
        input.setNonce_str(DataUtil.getRandomString(32));
        input.setBody(body);
        input.setOut_trade_no("2016090222478999");
        input.setTotal_fee("1");
        input.setTrade_type("NATIVE");
        input.setNotify_url("http://www.iquickgo.com/notify4Wechat.html");
        input.setSpbill_create_ip("192.168.4.116");
        input.setAttach("20963401");
        UnifiedOrderOutput output = WechatClient.unifiedorder(input,igo_wechat_apikey);
//        UnifiedOrderOutput output = WechatClient.unifiedorder(input,hanley_wechat_apikey);
        log.info("WechatClient.unifiedorder->output=\n"+output.toString());
        String qrcode = output.getCode_url();
        ZxingUtil.qrCode(qrcode,"png","/zone/"+input.getOut_trade_no()+".png");

    }


    public static void testCloseOrder(){
        CloseOrderInput input = new CloseOrderInput();
        input.setAppid(igo_wechat_appid);
        input.setMch_id(igo_wechat_mchid);
        input.setSub_mch_id("1000077001");
        input.setOut_trade_no("201703151531000");
        input.setNonce_str(DataUtil.getRandomString(32));
        CloseOrderOutput output = WechatClient.closeOrder(input,igo_wechat_apikey);
        log.info("WechatClient.closeOrder->output=\n"+output.toString());
    }

    public static void test_postMicroMch(){
        MicroMchInput input = new MicroMchInput();
        input.setAppid(igo_wechat_appid);
        input.setMch_id(igo_wechat_mchid);
        input.setMerchant_name("Handy Pretty Tea");
        input.setMerchant_shortname("Hanley");
        input.setRecipient_name("汤翰林");
        input.setRecipient_idcardno("511381198710080079");
        input.setRecipient_wechatid("hanleytang");
        input.setBusiness("292");
        input.setMerchant_remark("10251@who1@1488273815049");
        input.setMerchant_gbaddress("310105");
        input.setMerchant_detailaddress("上海市长宁区昭化路96号");

        input.setContact("汤翰林");
        input.setContact_phone("18650002030");
        input.setContact_email("hanley@hanley.cn");
        input.setService_phone("021-61157725");

        WechatClient.postMicroMch(input,igo_wechat_apikey,p12FilePath);
    }


    public static void test_QueryMicroMch(){
        MicroMchInput input = new MicroMchInput();
        input.setAppid(igo_wechat_appid);
        input.setMch_id(igo_wechat_mchid);
        input.setRecipient_wechatid("hanleytang");
        WechatClient.queryMicroMch(input,igo_wechat_apikey,p12FilePath);

        /*
        <xml>
<appid><![CDATA[wxc475c2bd2958388e]]></appid>
<sign><![CDATA[0C52EADB2223D325FA3BB891A1903545]]></sign>
<business_0><![CDATA[292]]></business_0>
<business_1><![CDATA[292]]></business_1>
<contact_0><![CDATA[汤翰林]]></contact_0>
<contact_1><![CDATA[汤翰林]]></contact_1>
<contact_email_0><![CDATA[hanley@hanley.cn]]></contact_email_0>
<contact_email_1><![CDATA[hanley@hanley.cn]]></contact_email_1>
<contact_phone_0><![CDATA[18650002030]]></contact_phone_0>
<contact_phone_1><![CDATA[18650002030]]></contact_phone_1>
<mch_id><![CDATA[1386246702]]></mch_id>
<merchant_address_0><![CDATA[上海市长宁区华阳街道昭化路96号]]></merchant_address_0>
<merchant_address_1><![CDATA[上海市长宁区上海市长宁区昭化路96号]]></merchant_address_1>
<merchant_name_0><![CDATA[Hanley Coffee]]></merchant_name_0>
<merchant_name_1><![CDATA[Hanley Tea]]></merchant_name_1>
<merchant_remark_0><![CDATA[1025@saas@hanley@20170222]]></merchant_remark_0>
<merchant_remark_1><![CDATA[10251@who1@1488273815049]]></merchant_remark_1>
<merchant_shortname_0><![CDATA[HC]]></merchant_shortname_0>
<merchant_shortname_1><![CDATA[HT]]></merchant_shortname_1>
<micro_mch_id_0><![CDATA[20963401]]></micro_mch_id_0>
<micro_mch_id_1><![CDATA[21736045]]></micro_mch_id_1>
<recipient_idcardno_0><![CDATA[511381198710080079]]></recipient_idcardno_0>
<recipient_idcardno_1><![CDATA[511381198710080079]]></recipient_idcardno_1>
<recipient_name_0><![CDATA[汤翰林]]></recipient_name_0>
<recipient_name_1><![CDATA[汤翰林]]></recipient_name_1>
<recipient_wechatid_0><![CDATA[hanleytang]]></recipient_wechatid_0>
<recipient_wechatid_1><![CDATA[hanleytang]]></recipient_wechatid_1>
<record_num><![CDATA[2]]></record_num>
<result_code><![CDATA[SUCCESS]]></result_code>
<return_code><![CDATA[SUCCESS]]></return_code>
<return_msg><![CDATA[OK]]></return_msg>
<service_phone_0><![CDATA[021-61157725]]></service_phone_0>
<service_phone_1><![CDATA[021-61157725]]></service_phone_1>

</xml>
         */
    }

}
