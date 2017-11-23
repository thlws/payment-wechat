package org.thlws.payment.wechat.core;

import com.thoughtworks.xstream.XStream;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.thlws.payment.wechat.api.WechatApi;
import org.thlws.payment.wechat.entity.input.*;
import org.thlws.payment.wechat.entity.output.*;
import org.thlws.payment.wechat.extra.xml.XStreamCreator;
import org.thlws.payment.wechat.utils.ConnUtil;
import org.thlws.payment.wechat.utils.ThlwsBeanUtil;
import org.thlws.payment.wechat.utils.WechatUtil;

/**
 * 微信支付核心处理 <br>
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/sl.html">https://pay.weixin.qq.com/wiki/doc/api/sl.html</a>
 * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/index.html">https://pay.weixin.qq.com/wiki/doc/api/index.html</a>
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class WechatCore implements WechatApi{

    private static final Log log = LogFactory.get();

    /**
     * 微信统一下单，同时支援扫码支付统一下单 和 微信公众号统一下单 <br>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1">https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1</a>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_1">https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_1</a>
     * @param data   统一下单参数对象 {@link UnifiedOrderInput}
     * @param apiKey 微信API秘钥
     * @return  统一下单结果对象 {@link UnifiedOrderOutput}
     */
    public static UnifiedOrderOutput unifiedorder(UnifiedOrderInput data, String apiKey){

        UnifiedOrderOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,UnifiedOrderInput.class,apiKey);
            XStream xStream =  XStreamCreator.create(UnifiedOrderInput.class);
            String xml = xStream.toXML(input);
            log.info("微信统一下单请求数据[unifiedorder]->xmlRequest:\n {}",xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_unifiedorder);
            log.info("微信统一下单返回数据[unifiedorder]->xmlResponse:\n {}",ThlwsBeanUtil.formatXml(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(UnifiedOrderOutput.class);
            output = (UnifiedOrderOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
            log.info("微信统一下单[unifiedorder]失败:{}",e.getMessage());
        }

        return output;

    }


    /**
     * 微信退款,必须指定p12文件路径,否则无法完成退款动作,目前已知退款和撤销接口需要提供p12文件 <br>
     * <h5>使用该接口注意事项</h5>
     * <ol>
     *     <li>交易时间超过一年的订单无法提交退款;</li>
     *     <li>微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号;</li>
     *     <li>请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次错误或无效请求频率限制：6qps，即每秒钟异常或错误的退款申请请求不超过6次;</li>
     *     <li>每个支付订单的部分退款次数不能超过50次;</li>
     * </ol>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4">https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_4</a>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_4">https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_4</a>
     * @param data        退款参数对象 {@link WechatRefundInput}
     * @param apiKey      微信API秘钥
     * @param p12FilePath 微信p12文件路径
     * @return 微信退款结果对象 {@link WechatRefundOutput}
     */
    public static WechatRefundOutput refund(WechatRefundInput data, String apiKey, String p12FilePath){

        WechatRefundOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,WechatRefundInput.class,apiKey);
            XStream xStream = XStreamCreator.create(WechatRefundInput.class);
            String xml = xStream.toXML(input);
            log.info("微信退款请求数据[refund]->xmlRequest:\n {}",xml);

            String xmlResponse = ConnUtil.encryptPost(xml, pay_refund, data.getMch_id(), p12FilePath);
            log.info("微信退款响应数据[refund]->xmlResponse:\n {}",ThlwsBeanUtil.formatXml(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(WechatRefundOutput.class);
            output = (WechatRefundOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信退款[refund]失败:{}",e.getMessage());
        }
        return output;

    }


    /**
     * 微信订单查询,除核心参数外(appid,mch_id等为核心参数)业务参数 transaction_id ,out_trade_no 二选一即可<br>
     *
     * <h5>需要调用查询接口的情况</h5>
     *  <ol>
     *      <li>当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；</li>
     *      <li>调用支付接口后，返回系统错误或未知交易状态情况；</li>
     *      <li>调用刷卡支付API，返回USERPAYING的状态；</li>
     *      <li>调用关单或撤销接口API之前，需确认支付状态；</li>
     *  </ol>
     *
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2">https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_2</a>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_2">https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_2</a>
     * @param data  查询参数对象 {@link OrderQueryInput}
     * @param apiKey API秘钥
     * @return 订单查询结果对象 {@link OrderQueryOutput}
     */
    public static OrderQueryOutput orderQuery(OrderQueryInput data, String apiKey){

        OrderQueryOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,OrderQueryInput.class,apiKey);
            XStream xStream =  XStreamCreator.create(OrderQueryInput.class);
            String xml = xStream.toXML(input);
            log.info("微信订单查询请求数据[orderQuery]->xmlRequest:\n {}",xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_orderquery);
            log.info("微信订单查询响应数据[orderQuery]->response xmlResponse:\n {}",ThlwsBeanUtil.formatXml(xmlResponse));
            XStream xStreamOut =  XStreamCreator.create(OrderQueryOutput.class);
            output = (OrderQueryOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
           log.error("微信订单查询失败:{}",e.getMessage());
        }

        return  output;
    }


    /**
     * 微信撤销订单<br>
     * <h5>使用情境</h5>
     * <p>支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，微信支付系统会将此订单关闭；如果用户支付成功，微信支付系统会将此订单资金退还给用户。</p>
     * <h5>注意</h5>
     * <p>7天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。提交支付交易后调用【查询订单API】，  没有明确的支付结果再调用【撤销订单API】</p>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_11&index=3">https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_11&index=3</a>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_11&index=3">https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_11&index=3</a>
     * @param data        撤销参数对象 {@link WechatReverseInput}
     * @param apiKey      API秘钥
     * @param p12FilePath p12文件路径
     * @return 撤销结果对象 {@link WechatReverseOutput}
     */
    public static WechatReverseOutput reverse(WechatReverseInput data, String apiKey, String p12FilePath){

        WechatReverseOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,WechatReverseInput.class,apiKey);
            XStream xStream = XStreamCreator.create(WechatReverseInput.class);
            String xml = xStream.toXML(input);
            log.info("微信撤销订单请求数据[reverse]->xmlRequest:\n {}",xml);

            String xmlResponse = ConnUtil.encryptPost(xml, pay_reverse, data.getMch_id(), p12FilePath);
            log.info("微信撤销订单响应数据[reverse]->xmlResponse:\n {}",ThlwsBeanUtil.formatXml(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(WechatReverseOutput.class);
            output = (WechatReverseOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信撤销订单[reverse]失败:{}",e.getMessage());
        }
        return output;

    }


    /**
     * 微信订单关闭,商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口.<br>
     * <span style="color:red;">订单生成后不能马上调用关单接口，最短调用时间间隔为5分钟。</span>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3">https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_3</a> <br>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_3">https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_3</a>
     * @param data   参数对象 {@link CloseOrderInput}
     * @param apiKey 微信API秘钥
     * @return 订单关闭结果对象 {@link CloseOrderOutput}
     */
    public static CloseOrderOutput closeOrder(CloseOrderInput data, String apiKey){

        CloseOrderOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,CloseOrderInput.class,apiKey);
            XStream xStream = XStreamCreator.create(CloseOrderInput.class);
            String xml = xStream.toXML(input);
            log.info("微信关闭订单请求数据[closeOrder]->xmlRequest:\n {}",xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,close_order);

            log.info("微信关闭订单响应数据[closeOrder]->xmlResponse:\n {}",ThlwsBeanUtil.formatXml(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(CloseOrderOutput.class);
            output = (CloseOrderOutput) xStreamOut.fromXML(xmlResponse);

        } catch (Exception e) {
            log.error("微信关闭订单[closeOrder]失败:{}",e.getMessage());
        }
        return output;
    }



    /***
     * 微信刷卡支付,商户使用扫描枪扫用户微信支付码,消费者为被扫码对象,此方式与扫码支付扫码方式相反.<br>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_10&index=1">https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_10&index=1</a>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_10&index=1">https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_10&index=1</a>
     * <h5>提醒事项</h5>
     * <ol>
     *     <li>提交支付请求后微信会同步返回支付结果。当返回结果为“系统错误”时，商户系统等待5秒后调用【查询订单API】，查询支付实际交易结果；当返回结果为“USERPAYING”时，商户系统可设置间隔时间(建议10秒)重新查询支付结果，直到支付成功或超时(建议30秒)；</li>
     *     <li>在调用查询接口返回后，如果交易状况不明晰，请调用【撤销订单API】，此时如果交易失败则关闭订单，该单不能再支付成功；如果交易成功，则将扣款退回到用户账户。当撤销无返回或错误时，请再次调用。注意：请勿扣款后立即调用【撤销订单API】,建议至少15秒后再调用。撤销订单API需要双向证书。</li>
     * </ol>
     * @param data 支付参数对象 {@link WechatPayInput}
     * @param apiKey 微信API秘钥
     * @return 支付结果对象 {@link WechatPayOutput}
     */
    public static WechatPayOutput micropay(WechatPayInput data, String apiKey){

        WechatPayOutput output = null;

        try {
            Object input = WechatUtil.buildRequest(data,WechatPayInput.class,apiKey);
            XStream xStream = XStreamCreator.create(WechatPayInput.class);
            String xml = xStream.toXML(input);
            log.info("微信支付请求数据[micropay]->xmlRequest:\n {}",xml);

            String xmlResponse = ConnUtil.connRemoteWithXml(xml,pay_micropay);
            log.info("微信支付响应数据[micropay]->response xmlResponse:\n {}", ThlwsBeanUtil.formatXml(xmlResponse));
            XStream xStreamOut = XStreamCreator.create(WechatPayOutput.class);
            output = (WechatPayOutput) xStreamOut.fromXML(xmlResponse);
        } catch (Exception e) {
            log.error("微信线下支付失败:{}",e.getMessage());
        }

        return output;
    }

}
