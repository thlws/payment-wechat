<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="overflow:auto"
	dir="ltr" class="uk-notouch">
	
<%@ include file="/common/meta2.jsp"%>
<script type="text/javascript">
	
	$("title").html("微信支付");
	
	var wechat_pay_recharge = "recharge";
	var wechat_pay_order = "order";
	var wechat_pay_ext = "extpaid";
	var wechat_pay_buycards = "buycards";
	
	var wechat_pay_type = '${wechat_pay_type}';
	var uniquePaymetyType = '${uniquePaymetyType}';
	var is_ordering = false;
	var is_recharging = false;
	var is_extpaid = false;
	var is_buycards = false;
	
	if(wechat_pay_type == wechat_pay_recharge)
		is_recharging = true;
	else if(wechat_pay_type == wechat_pay_order)
		is_ordering = true;
	else if(wechat_pay_type == wechat_pay_ext)
		is_extpaid = true;
	else if(wechat_pay_type == wechat_pay_buycards)
		is_buycards = true;

	function onBridgeReady() {
		WeixinJSBridge.invoke('getBrandWCPayRequest', {
			"appId" : '${appId}',
			"timeStamp" : '${timeStamp}',   
			"nonceStr" : '${nonceStr}',
			"package" : '${packageStr}',
			"signType" : '${signType}',   
			"paySign" :  '${paySign}'
		}, function(res) {
			if (res.err_msg == "get_brand_wcpay_request:ok") {
				
				//等待3秒，留给微信异步一定时间
				delay_biz();
				//setTimeout(delay_biz,500);
				
		} // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
		else{ 
			//订单被取消
			if(res.err_msg == "get_brand_wcpay_request:cancel")
				showWarningMsg("支付被取消.");
			else//其他异常弹出对应异常信息
				showWarningMsg("订单异常.");
			
			setTimeout(back_operation_page,1500);
		}
		});
	}
	
	if (typeof WeixinJSBridge == "undefined") {
		if (document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady',onBridgeReady, false);
		} else if (document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		}
	} else {
		onBridgeReady();
	}
			
	function callback_wechat_order() {
		$.ajax({
			'url':'${pageContext.request.contextPath}/pay/callback_inwechat_order.html',//二次check
			'data':'',
			'dataType':'json',
			'type':'post',
			'async':'false',
			'success':function(data){
				if(data == true || data == 'true'){
					window.location.href = "${pageContext.request.contextPath}/storePage.html";
				}
			}
		});
	}
	
	function callback_wechat_recharge() {
		$.ajax({
			'url':'${pageContext.request.contextPath}/pay/callback_inwechat_recharge.html',//二次check
			'data':'',
			'dataType':'json',
			'type':'post',
			'async':'false',
			'success':function(data){
				if(data == true || data == 'true'){
					 window.location.href='${pageContext.request.contextPath}/showvcard.html';
				}
			}
		});
	}
	
	
	function callback_wechat_ext() {
		$.ajax({
			'url':'${pageContext.request.contextPath}/pay/callback_inwechat_ext.html',//二次check
			'data':'',
			'dataType':'json',
			'type':'post',
			'async':'false',
			'success':function(data){
				if(data == true || data == 'true'){
					 window.location.href='${pageContext.request.contextPath}/myCoupons.html';//显示 礼券页面
				}
			}
		});
	}
	
	
	function callback_wechat_buycards() {
		$.ajax({
			'url':'${pageContext.request.contextPath}/pay/callback_inwechat_buycards.html',//二次check
			'data':'',
			'dataType':'json',
			'type':'post',
			'async':'false',
			'success':function(data){
				if(data == true || data == 'true'){
					 window.location.href='${pageContext.request.contextPath}/goBindShoppingCard.html';
				}
			}
		});
	}
	
	
	function retry(){
		window.location.reload();
	}
	
	
	function back_operation_page(){
		if(is_recharging){
			window.location.href="${pageContext.request.contextPath}/showvcard.html";
		}else if(is_extpaid){
			window.location.href="${pageContext.request.contextPath}/paid_member_tips.html";
		}else if(is_buycards){
			window.location.href="${pageContext.request.contextPath}/showCardsMail.html";
		}else{
			if(uniquePaymetyType == "false"){
				window.location.href="${pageContext.request.contextPath}/payments.html";
			}else{
			 	window.location.href="${pageContext.request.contextPath}/go_order_operation.html";
			}
		}
	}
	
	
	function delay_biz(){
		
		if(is_recharging)
			setInterval(callback_wechat_recharge,2000);
		if(is_ordering)
			setInterval(callback_wechat_order,2000);
		if(is_extpaid)
			setInterval(callback_wechat_ext,2000);
		if(is_buycards)
			setInterval(callback_wechat_buycards,2000);
	}
	
</script>
<style>
.igo-lucency{
	color: white;
    background-color: rgba(51,51,51,0.5);
}
</style>
<head></head>
<body>
	<div class="igo-content">
		  <div class="uk-alert uk-alert-warning uk-text-center igo-lucency" style="padding-left: 50px;padding-right: 50px;">等待支付</div>
	</div>
	
  <div class="igo-footer uk-text-center">
    <span id="igo-footid" style="line-height: 40px;">我们是爱快购O2O平台</span>
 </div>
</body>
</html>
