package org.thlws.payment.wechat;

import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.OrderQueryOutput;
import org.thlws.payment.wechat.entity.output.WechatPayOutput;
import org.thlws.payment.wechat.entity.output.WechatRefundOutput;
import org.thlws.payment.wechat.entity.output.WechatReverseOutput;
import org.thlws.payment.wechat.portal.client.WechatClient;
import org.thlws.payment.wechat.utils.DataUtil;
import org.thlws.payment.wechat.utils.DateUtil;
import org.thlws.payment.wechat.utils.LocalUtil;


/**
 * 微信非公众号支付测试
 * Created by HanleyTang on 16/9/4.
 */
public class WechatClientTest extends TestCase{

    static final protected Logger log = LoggerFactory.getLogger(WechatClientTest.class);

    /***
     * 付款
     */
    public void testPay(){
        log.info("微信下线[支付]测试开始-WechatClient.micropay");
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        WechatPayInput input = new WechatPayInput();
        input.setAppid("wx5f22a16d8c94dba4");
        input.setMch_id("1336236101");
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
     * 付款(特约商户)
     */
    public void testPay4MicroMch(){
        log.info("微信下线[支付]测试开始-WechatClient.micropay");
        String apiKey = "f02f5eecfed86f8a3cf753697fbf3246";
        WechatPayInput input = new WechatPayInput();
        input.setSub_mch_id("1396726602");
        input.setAppid("wxc475c2bd2958388e");
        input.setMch_id("1386246702");
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
     * 退款[音嘉爱快购]
     */
    public void testRefund4Enjar(){
        log.info("微信.音嘉爱快购[退款]测试开始-WechatClient.refund");
        String p12FilePath = "/zone/p12/1336234701.p12";//音嘉爱快购p12
        log.info("微信下线[退款]测试开始-WechatClient.refund");
        WechatRefundInput data = new WechatRefundInput();
        String apiKey = "3841ed233e4d3294c03c1e03c31bbec9";
        data.setAppid("wx60dd84460beff674");
        data.setMch_id("1336234701");
        data.setTransaction_id("4007402001201611220501202581");
        data.setOut_trade_no("20161122172145");
        data.setOut_refund_no(DateUtil.getDateSecondFormatII());
        data.setTotal_fee("1000");
        data.setRefund_fee("1000");
        data.setOp_user_id("1336234701");
        data.setNonce_str(DataUtil.getRandomString(32));
        WechatRefundOutput output = WechatClient.refund(data,apiKey,p12FilePath);
        log.info("WechatClient.refund->output="+output.toString());

        assertEquals(output.getReturn_code(),"SUCCESS");
    }


    /***
     * 退款[翰林爱快购]
     */
    public void testRefund4Hanley(){
        log.info("微信.翰林爱快购[退款]测试开始-WechatClient.refund");
        String p12FilePath = "/zone/p12/1336236101.p12";//翰林爱快购p12
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        WechatRefundInput data = new WechatRefundInput();
        data.setAppid("wx5f22a16d8c94dba4");
        data.setMch_id("1336236101");
        data.setTransaction_id("4005332001201611220513588126");
        data.setOut_trade_no("20161122191505");
        data.setOut_refund_no(DateUtil.getDateSecondFormatII());
        data.setTotal_fee("1000");
        data.setRefund_fee("1000");
        data.setOp_user_id("1336236101");
        data.setNonce_str(DataUtil.getRandomString(32));

        WechatRefundOutput output = WechatClient.refund(data,apiKey,p12FilePath);
        log.info("WechatClient.refund->output="+output.toString());
        assertEquals(output.getReturn_code(),"SUCCESS");
    }


    /***
     * 退款(特约商户)[爱快购微商城]
     */
    public void testRefund4SubMch(){
        String p12FilePath = "/zone/p12/1386246702.p12";//爱快购微商城p12
        log.info("微信.爱快购微商城[退款]测试开始-WechatClient.refund");
        WechatRefundInput data = new WechatRefundInput();
        data.setSub_mch_id("1396726602");
        String apiKey = "f02f5eecfed86f8a3cf753697fbf3246";
        data.setAppid("wxc475c2bd2958388e");
        data.setMch_id("1386246702");
        data.setTransaction_id("4007402001201611119430531609");
        data.setOut_trade_no("20160902224757");
        data.setOut_refund_no(DateUtil.getDateSecondFormatII());
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
    public void testOrderQuery(){

        log.info("微信[订单查询]测试开始-WechatClient.orderQuery");
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        OrderQueryInput input = new OrderQueryInput();
        input.setAppid("wx5f22a16d8c94dba4");
        input.setMch_id("1336236101");
        input.setTransaction_id("4005332001201610166835977303");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(DataUtil.getRandomString(32));
        OrderQueryOutput output = WechatClient.orderQuery(input,apiKey);
        log.info("WechatClient.orderQuery->output="+output.toString());
    }

    /**
     * 订单查询(特约商户)
     */
    public void testOrderQuery4subMch(){

        log.info("微信[订单查询]测试开始-WechatClient.orderQuery");
        String apiKey = "f02f5eecfed86f8a3cf753697fbf3246";
        OrderQueryInput input = new OrderQueryInput();
        input.setSub_mch_id("1396726602");
        input.setAppid("wxc475c2bd2958388e");
        input.setMch_id("1386246702");
        input.setTransaction_id("4000552001201610287969714637");
        input.setOut_trade_no("20161028155711");
        input.setNonce_str(DataUtil.getRandomString(32));
        OrderQueryOutput output = WechatClient.orderQuery(input,apiKey);
        log.info("WechatClient.orderQuery->output="+output.toString());
    }

    /***
     * 撤销订单
     */
    public void testReverse(){

        log.info("微信[撤销订单]测试开始-WechatClient.reverse");
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        WechatReverseInput input = new WechatReverseInput();
        input.setAppid("wx5f22a16d8c94dba4");
        input.setMch_id("1336236101");
        input.setTransaction_id("1217752501201407033233368018");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(DataUtil.getRandomString(32));
        String p12FilePath = "/zone/p12/1336236101.p12";
        WechatReverseOutput output = WechatClient.reverse(input,apiKey,p12FilePath);

    }


    /***
     * 撤销订单(特约商户号)
     */
    public void testReverse4SubMch(){

        log.info("微信[撤销订单]测试开始-WechatClient.reverse");
        String apiKey = "d24a3e612fca66ae28137de28916f875";
        WechatReverseInput input = new WechatReverseInput();
        input.setAppid("wx5f22a16d8c94dba4");
        input.setMch_id("1336236101");
        input.setTransaction_id("1217752501201407033233368018");
        input.setOut_trade_no("20160902224757");
        input.setNonce_str(DataUtil.getRandomString(32));
        input.setSub_mch_id("1396726602");
        String p12FilePath = "/zone/p12/1336236101.p12";
        WechatReverseOutput output = WechatClient.reverse(input,apiKey,p12FilePath);

    }

    /***
     * 提交小微申请，暂未启用,未来可能移除
     *  @deprecated
     */
    public void testPostSubmch(){

        String apiKey = "ig9PXjJ5im8o3sfb3kuIYJ4wqTvGmzQX";

        //just for  add(新增收款个人用户)
        MicroMchInput wr = new MicroMchInput();
        wr.setAppid("wx5f22a16d8c94dba4");
        wr.setMch_id("1336236101");
        wr.setMerchant_name("翰林美食铺");
        wr.setMerchant_shortname("Hanley");
        wr.setRecipient_name("汤翰林");
        wr.setRecipient_idcardno("511381198710080079");
        wr.setRecipient_wechatid("hanleytang");
        wr.setBusiness("食品");
        wr.setMerchant_remark("hanley20160827");
        wr.setMerchant_gbaddress("310105");
        wr.setMerchant_detailaddress("昭化路505号301室");
        WechatClient.postMicroMch(wr,apiKey,"");

    }

    /***
     * 查询小微资料，暂未启用,未来可能移除
     * @deprecated
     */
    public void testQuerySubmch(){

        String apiKey = "ig9PXjJ5im8o3sfb3kuIYJ4wqTvGmzQX";

        //just for query
        MicroMchInput wr2 = new MicroMchInput();
        wr2.setAppid("wx5f22a16d8c94dba4");
        wr2.setMch_id("1336236101");
        wr2.setRecipient_wechatid("hanleytang");
        WechatClient.queryMicroMch(wr2,apiKey,"");
    }

}
