package org.thlws.payment.wechat.entity.input;

import org.thlws.payment.wechat.utils.JsonUtil;

/**
 * 新增收款个人用户资料 Req POJO
 * 服务商调用该接口将收款个人用户资料提交给微信侧,微信根据提交的 资料情况,判断收款用户资料正确性,返回收款识别码;
 * @author Hanley Tang
 * @email hanley@hanley.cn
 * @version 1.0
 */
public class MicroMchInput {

	private String appid                  ;
	private String mch_id                 ;
	private String sign                   ;
	private String merchant_name          ;
	private String merchant_shortname     ;
	private String recipient_name         ;
	private String recipient_idcardno     ;
	private String business               ;
	private String merchant_remark        ;
	private String service_phone          ;
	private String merchant_gbaddress     ;
	private String merchant_detailaddress ;
	private String contact                ;
	private String contact_phone          ;
	private String contact_email          ;
	
	/**查询收款个人用户资料 [收款识别码 收款人微信号] 二选一*/
	private String recipient_wechatid     ;
	private String micro_mch_id;//收款识别码
	
	
	private String device_info;
	private String body;
	private String nonce_str;

	public String getDevice_info() {
		return device_info;
	}

	public String getBody() {
		return body;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public MicroMchInput() {
	}

	public String getMicro_mch_id() {
		return micro_mch_id;
	}

	public void setMicro_mch_id(String micro_mch_id) {
		this.micro_mch_id = micro_mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public String getSign() {
		return sign;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public String getMerchant_shortname() {
		return merchant_shortname;
	}

	public String getRecipient_name() {
		return recipient_name;
	}

	public String getRecipient_idcardno() {
		return recipient_idcardno;
	}

	public String getRecipient_wechatid() {
		return recipient_wechatid;
	}

	public String getBusiness() {
		return business;
	}

	public String getMerchant_remark() {
		return merchant_remark;
	}

	public String getService_phone() {
		return service_phone;
	}

	public String getMerchant_gbaddress() {
		return merchant_gbaddress;
	}

	public String getMerchant_detailaddress() {
		return merchant_detailaddress;
	}

	public String getContact() {
		return contact;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public void setMerchant_shortname(String merchant_shortname) {
		this.merchant_shortname = merchant_shortname;
	}

	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}

	public void setRecipient_idcardno(String recipient_idcardno) {
		this.recipient_idcardno = recipient_idcardno;
	}

	public void setRecipient_wechatid(String recipient_wechatid) {
		this.recipient_wechatid = recipient_wechatid;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public void setMerchant_remark(String merchant_remark) {
		this.merchant_remark = merchant_remark;
	}

	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}

	public void setMerchant_gbaddress(String merchant_gbaddress) {
		this.merchant_gbaddress = merchant_gbaddress;
	}

	public void setMerchant_detailaddress(String merchant_detailaddress) {
		this.merchant_detailaddress = merchant_detailaddress;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	@Override
	public String toString() {
		return JsonUtil.format(this);
	}
}
