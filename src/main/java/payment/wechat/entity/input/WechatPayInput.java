package payment.wechat.entity.input;

import payment.wechat.utils.JsonUtil;

/***
 * wechat pay pojo
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class WechatPayInput {

	private String openid           ;
	private String appid            ;
	private String mch_id           ;
	private String notify_url       ;
	private String trade_type       ;//JSAPI，NATIVE，APP
	private String nonce_str        ;
	private String sign             ;
	private String body             ;
	private String total_fee        ;
	private String spbill_create_ip ;
	private String out_trade_no		;
	private String auth_code		;	//y	   线下支付-[条码或者二维码信息]
	private String detail			;	//n    not required
	private String attach			;	//n    not required
	private String fee_type			;	//n    not required
	private String time_start		;	//n    not required
	private String time_expire		;	//n    not required
	private String goods_tag		;	//n    not required
	private String device_info		;	//n    not required
	private String product_id		;	//n    not required
	private String limit_pay		;	//n    not required
	private String sub_appid		;	//n    not required
	private String sub_mch_id		;	//n    not required

	public WechatPayInput() {}

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public String getOpenid() {
		return openid;
	}

	public String getAppid() {
		return appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public String getBody() {
		return body;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public String getDetail() {
		return detail;
	}

	public String getAttach() {
		return attach;
	}

	public String getFee_type() {
		return fee_type;
	}

	public String getTime_start() {
		return time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public String getDevice_info() {
		return device_info;
	}

	public String getProduct_id() {
		return product_id;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
