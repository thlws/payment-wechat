package org.thlws.payment.wechat.entity.output;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 微信订单查询结果对象
 *
 * @author Hanley | hanley@thlws.com
 * @version 1.0
 */
public class OrderQueryOutput {

    /**返回状态码*/
    private String return_code;

    /**返回信息*/
    private String return_msg;

    /**公众账号ID*/
    private String appid;

    /**商户号*/
    private String mch_id;

    /**随机字符串	*/
    private String nonce_str;

    /**签名*/
    private String sign;

    /**业务结果*/
    private String result_code;

    /**
     * 错误代码
     * */
    private String err_code;

    /**错误代码描述*/
    private String err_code_des;

    /**设备号,微信支付分配的终端设备号*/
    private String device_info;

    /**用户在商户appid下的唯一标识*/
    private String openid;

    /**是否关注公众账号*/
    private String is_subscribe;

    /**交易类型 JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付、MWEB--H5支付、MICROPAY--刷卡支付<br>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=4_2">https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=4_2</a>
     * */
    private String trade_type;

    /**交易状态 <br>
     * <ol>
     *    <li>SUCCESS—支付成功</li>
     *    <li>REFUND—转入退款</li>
     *    <li>NOTPAY—未支付</li>
     *    <li>CLOSED—已关闭</li>
     *    <li>REVOKED—已撤销(刷卡支付)</li>
     *    <li>USERPAYING--用户支付中</li>
     *    <li>PAYERROR--支付失败(其他原因，如银行返回失败)</li>
     * </ol>
     * */
    private String trade_state;

    /**付款银行 <br>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=4_2#8">https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=4_2#8</a>
     * */
    private String bank_type;

    /**订单总金额，单位为分*/
    private String total_fee;

    /***/
    private String settlement_total_fee;

    /**货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY<br>
     * @see <a href="https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=4_2#4">https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=4_2#4</a>
     * */
    private String fee_type;

    /**订单现金支付金额*/
    private String cash_fee;

    /**现金支付货币类型,默认人民币：CNY*/
    private String cash_fee_type;

    /**代金券金额	,“代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额*/
    private String coupon_fee;

    /**代金券或立减优惠使用数量*/
    private String coupon_count;

    /**微信支付订单号*/
    private String transaction_id;

    /**商户订单号*/
    private String out_trade_no;

    /**商家数据包，原样返回*/
    private String attach;

    /**支付完成时间*/
    private String time_end;

    /**交易状态描述*/
    private String trade_state_desc;

    /**子商户公众账号ID*/
    private String sub_appid;

    /**子商户号*/
    private String sub_mch_id;

//    private String coupon_batch_id_$n;
//    private String coupon_type_$n;
//    private String coupon_id_$n;
//    private String coupon_fee_$n;

    /**代金券类型-0*/
    private String coupon_type_0;

    /**代金券类型-1*/
    private String coupon_type_1;

    /**代金券类型-2*/
    private String coupon_type_2;

    /**代金券ID-0*/
    private String coupon_id_0;

    /**代金券ID-1*/
    private String coupon_id_1;

    /**代金券ID-2*/
    private String coupon_id_2;

    /**单个代金券金额-0*/
    private String coupon_fee_0;

    /**单个代金券金额-1*/
    private String coupon_fee_1;

    /**单个代金券金额-2*/
    private String coupon_fee_2;

    @Override
    public String toString() {
        return JsonUtil.format(this);
    }

    /**
     * Instantiates a new Order query output.
     */
    public OrderQueryOutput() {
    }

    /**
     * Gets sub appid.
     *
     * @return the sub appid
     */
    public String getSub_appid() {
        return sub_appid;
    }

    /**
     * Sets sub appid.
     *
     * @param sub_appid the sub appid
     */
    public void setSub_appid(String sub_appid) {
        this.sub_appid = sub_appid;
    }

    /**
     * Gets sub mch id.
     *
     * @return the sub mch id
     */
    public String getSub_mch_id() {
        return sub_mch_id;
    }

    /**
     * Sets sub mch id.
     *
     * @param sub_mch_id the sub mch id
     */
    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    /**
     * Gets return code.
     *
     * @return the return code
     */
    public String getReturn_code() {
        return return_code;
    }

    /**
     * Sets return code.
     *
     * @param return_code the return code
     */
    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    /**
     * Gets return msg.
     *
     * @return the return msg
     */
    public String getReturn_msg() {
        return return_msg;
    }

    /**
     * Sets return msg.
     *
     * @param return_msg the return msg
     */
    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    /**
     * Gets appid.
     *
     * @return the appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * Sets appid.
     *
     * @param appid the appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * Gets mch id.
     *
     * @return the mch id
     */
    public String getMch_id() {
        return mch_id;
    }

    /**
     * Sets mch id.
     *
     * @param mch_id the mch id
     */
    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    /**
     * Gets nonce str.
     *
     * @return the nonce str
     */
    public String getNonce_str() {
        return nonce_str;
    }

    /**
     * Sets nonce str.
     *
     * @param nonce_str the nonce str
     */
    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    /**
     * Gets sign.
     *
     * @return the sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * Sets sign.
     *
     * @param sign the sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * Gets result code.
     *
     * @return the result code
     */
    public String getResult_code() {
        return result_code;
    }

    /**
     * Sets result code.
     *
     * @param result_code the result code
     */
    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    /**
     * Gets err code.
     *
     * @return the err code
     */
    public String getErr_code() {
        return err_code;
    }

    /**
     * Sets err code.
     *
     * @param err_code the err code
     */
    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    /**
     * Gets err code des.
     *
     * @return the err code des
     */
    public String getErr_code_des() {
        return err_code_des;
    }

    /**
     * Sets err code des.
     *
     * @param err_code_des the err code des
     */
    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    /**
     * Gets device info.
     *
     * @return the device info
     */
    public String getDevice_info() {
        return device_info;
    }

    /**
     * Sets device info.
     *
     * @param device_info the device info
     */
    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    /**
     * Gets openid.
     *
     * @return the openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * Sets openid.
     *
     * @param openid the openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * Gets is subscribe.
     *
     * @return the is subscribe
     */
    public String getIs_subscribe() {
        return is_subscribe;
    }

    /**
     * Sets is subscribe.
     *
     * @param is_subscribe the is subscribe
     */
    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    /**
     * Gets trade type.
     *
     * @return the trade type
     */
    public String getTrade_type() {
        return trade_type;
    }

    /**
     * Sets trade type.
     *
     * @param trade_type the trade type
     */
    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    /**
     * Gets trade state.
     *
     * @return the trade state
     */
    public String getTrade_state() {
        return trade_state;
    }

    /**
     * Sets trade state.
     *
     * @param trade_state the trade state
     */
    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    /**
     * Gets bank type.
     *
     * @return the bank type
     */
    public String getBank_type() {
        return bank_type;
    }

    /**
     * Sets bank type.
     *
     * @param bank_type the bank type
     */
    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    /**
     * Gets total fee.
     *
     * @return the total fee
     */
    public String getTotal_fee() {
        return total_fee;
    }

    /**
     * Sets total fee.
     *
     * @param total_fee the total fee
     */
    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    /**
     * Gets settlement total fee.
     *
     * @return the settlement total fee
     */
    public String getSettlement_total_fee() {
        return settlement_total_fee;
    }

    /**
     * Sets settlement total fee.
     *
     * @param settlement_total_fee the settlement total fee
     */
    public void setSettlement_total_fee(String settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    /**
     * Gets fee type.
     *
     * @return the fee type
     */
    public String getFee_type() {
        return fee_type;
    }

    /**
     * Sets fee type.
     *
     * @param fee_type the fee type
     */
    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    /**
     * Gets cash fee.
     *
     * @return the cash fee
     */
    public String getCash_fee() {
        return cash_fee;
    }

    /**
     * Sets cash fee.
     *
     * @param cash_fee the cash fee
     */
    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }

    /**
     * Gets cash fee type.
     *
     * @return the cash fee type
     */
    public String getCash_fee_type() {
        return cash_fee_type;
    }

    /**
     * Sets cash fee type.
     *
     * @param cash_fee_type the cash fee type
     */
    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    /**
     * Gets coupon fee.
     *
     * @return the coupon fee
     */
    public String getCoupon_fee() {
        return coupon_fee;
    }

    /**
     * Sets coupon fee.
     *
     * @param coupon_fee the coupon fee
     */
    public void setCoupon_fee(String coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    /**
     * Gets coupon count.
     *
     * @return the coupon count
     */
    public String getCoupon_count() {
        return coupon_count;
    }

    /**
     * Sets coupon count.
     *
     * @param coupon_count the coupon count
     */
    public void setCoupon_count(String coupon_count) {
        this.coupon_count = coupon_count;
    }

    /**
     * Gets transaction id.
     *
     * @return the transaction id
     */
    public String getTransaction_id() {
        return transaction_id;
    }

    /**
     * Sets transaction id.
     *
     * @param transaction_id the transaction id
     */
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    /**
     * Gets out trade no.
     *
     * @return the out trade no
     */
    public String getOut_trade_no() {
        return out_trade_no;
    }

    /**
     * Sets out trade no.
     *
     * @param out_trade_no the out trade no
     */
    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    /**
     * Gets attach.
     *
     * @return the attach
     */
    public String getAttach() {
        return attach;
    }

    /**
     * Sets attach.
     *
     * @param attach the attach
     */
    public void setAttach(String attach) {
        this.attach = attach;
    }

    /**
     * Gets time end.
     *
     * @return the time end
     */
    public String getTime_end() {
        return time_end;
    }

    /**
     * Sets time end.
     *
     * @param time_end the time end
     */
    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    /**
     * Gets trade state desc.
     *
     * @return the trade state desc
     */
    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    /**
     * Gets coupon type 0.
     *
     * @return the coupon type 0
     */
    public String getCoupon_type_0() {
        return coupon_type_0;
    }

    /**
     * Sets coupon type 0.
     *
     * @param coupon_type_0 the coupon type 0
     */
    public void setCoupon_type_0(String coupon_type_0) {
        this.coupon_type_0 = coupon_type_0;
    }

    /**
     * Gets coupon type 1.
     *
     * @return the coupon type 1
     */
    public String getCoupon_type_1() {
        return coupon_type_1;
    }

    /**
     * Sets coupon type 1.
     *
     * @param coupon_type_1 the coupon type 1
     */
    public void setCoupon_type_1(String coupon_type_1) {
        this.coupon_type_1 = coupon_type_1;
    }

    /**
     * Gets coupon type 2.
     *
     * @return the coupon type 2
     */
    public String getCoupon_type_2() {
        return coupon_type_2;
    }

    /**
     * Sets coupon type 2.
     *
     * @param coupon_type_2 the coupon type 2
     */
    public void setCoupon_type_2(String coupon_type_2) {
        this.coupon_type_2 = coupon_type_2;
    }

    /**
     * Gets coupon id 0.
     *
     * @return the coupon id 0
     */
    public String getCoupon_id_0() {
        return coupon_id_0;
    }

    /**
     * Sets coupon id 0.
     *
     * @param coupon_id_0 the coupon id 0
     */
    public void setCoupon_id_0(String coupon_id_0) {
        this.coupon_id_0 = coupon_id_0;
    }

    /**
     * Gets coupon id 1.
     *
     * @return the coupon id 1
     */
    public String getCoupon_id_1() {
        return coupon_id_1;
    }

    /**
     * Sets coupon id 1.
     *
     * @param coupon_id_1 the coupon id 1
     */
    public void setCoupon_id_1(String coupon_id_1) {
        this.coupon_id_1 = coupon_id_1;
    }

    /**
     * Gets coupon id 2.
     *
     * @return the coupon id 2
     */
    public String getCoupon_id_2() {
        return coupon_id_2;
    }

    /**
     * Sets coupon id 2.
     *
     * @param coupon_id_2 the coupon id 2
     */
    public void setCoupon_id_2(String coupon_id_2) {
        this.coupon_id_2 = coupon_id_2;
    }

    /**
     * Gets coupon fee 0.
     *
     * @return the coupon fee 0
     */
    public String getCoupon_fee_0() {
        return coupon_fee_0;
    }

    /**
     * Sets coupon fee 0.
     *
     * @param coupon_fee_0 the coupon fee 0
     */
    public void setCoupon_fee_0(String coupon_fee_0) {
        this.coupon_fee_0 = coupon_fee_0;
    }

    /**
     * Gets coupon fee 1.
     *
     * @return the coupon fee 1
     */
    public String getCoupon_fee_1() {
        return coupon_fee_1;
    }

    /**
     * Sets coupon fee 1.
     *
     * @param coupon_fee_1 the coupon fee 1
     */
    public void setCoupon_fee_1(String coupon_fee_1) {
        this.coupon_fee_1 = coupon_fee_1;
    }

    /**
     * Gets coupon fee 2.
     *
     * @return the coupon fee 2
     */
    public String getCoupon_fee_2() {
        return coupon_fee_2;
    }

    /**
     * Sets coupon fee 2.
     *
     * @param coupon_fee_2 the coupon fee 2
     */
    public void setCoupon_fee_2(String coupon_fee_2) {
        this.coupon_fee_2 = coupon_fee_2;
    }

    /**
     * Sets trade state desc.
     *
     * @param trade_state_desc the trade state desc
     */
    public void setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
    }
}
