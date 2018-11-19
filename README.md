微信支付
============
[![](https://img.shields.io/badge/release-v1.0.5-green.svg)](https://github.com/thlws/payment-wechat)   [![](https://img.shields.io/badge/license-Apache--2-yellowgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0.html) [![](https://img.shields.io/badge/maven%20central-v1.0.5-blue.svg)](https://search.maven.org/artifact/org.thlws/payment-wechat/1.0.5/jar) 
[![](https://img.shields.io/badge/jdk-1.7%2B-red.svg)](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
> 基于Java实现的 微信支付 依赖库。


#### 正在憋招，耐心等待...
【微信、支付宝、翼支付 三合一】 [https://gitee.com/thlws/payment-thl](https://gitee.com/thlws/payment-thl)

#### 有何理由用这个？
- 接口参数全部封装，使用者仅需创建对象并设置参数；
- 项目极少依赖，接口简单清晰，日志详细且输出格式友好；
- 各种支付平台，支付场景提供示例项目，新手更容易上手，降低接入门槛；

#### 支持的平台类型？
只支持Java平台，不支持Android App支付；
#### 支持哪些支付场景？
- 微信刷卡付款(商家扫码支付)
- 微信扫码支付(用户扫码支付)
- 微信公众号支付
- 支付宝网站支付付款
- 支付宝刷卡付款(商家扫码完成付款，官方叫当面付)
- 支付宝扫描支付(用户扫码支付)
- 支付宝H5网页支付
- 翼支付刷卡支付(商家扫码支付)

### 接口列表
**微信支付**
[org.thlws.payment.WechatPayClient](src/main/java/org/thlws/payment/WechatPayClient.java)

| 方法名称 | 功能说明 |
|:--------|:--------|
| unifiedOrder | 统一下单(类似预订单) |
| refund | 申请退款 |
| reverse | 支付撤销 |
| microPay | 刷卡支付 |
| orderQuery | 支付查询 |
| closeOrder | 订单关闭 |
| openidQuery | 查询OpenId|
| queryMicroMch | 查询小微收款人信息|
| postMicroMch | 申请开通小微收款功能|

**微信公众号**
[org.thlws.payment.WechatMpClient](src/main/java/org/thlws/payment/WechatMpClient.java)

| 方法名称 | 功能说明 |
|--------|--------|
| obtainOauthAccessToken | 获取accesToken(OAuth2) |
| refreshOauthAccessToken | 刷新accesToken(OAuth2) |
| isvalidOauthAccessToken | 验证token是否过期(OAuth2) |
| generateWechatUrl | 生成微信规则URL |
| obtainUserInfo | 获取用户资料|
| obtainAccessToken | 获取accesToken(普通) |
| obtainJsApiTicket | 获取JSAPI Ticket |
| obtainTemplateId | 获取微信消息模板ID |
| setupIndustry | 设置行业属性 |
| sendMsgToUser | 发送微信通知 |



### 更新日志
- v1.0.0 微信支付依赖库正式发布;
- v1.0.1 新增公众号支付时,token 和 open_id 获取接口;
- v1.0.2 修正Junit测试,增加Javadoc注释内容;
- v1.0.3 新增公众号支付示例代码,升级依赖库hutool;
- v1.0.4 依赖更新,新增授权码查询 openid 接口;
- v1.0.5 项目重构,部分修复 [issue#IOJTH](https://gitee.com/thlws/payment-wechat/issues/IOJTH),感谢永夜.



### 在线文档
- [ 使用手册,非最新文档,暂未更新 ](http://payment-wechat.mydoc.io/)   
- [ API 文档 ](https://apidoc.gitee.com/thlws/payment-wechat)

### 在线交流
- 邮箱：hanley@thlws.com 
- QQ群：  [![](https://img.shields.io/badge/chat-on%20qq-red.svg)](//shang.qq.com/wpa/qunwpa?idkey=521df1fba7ef96db15c898e48feb26b6a82f6c2a60612154181b301febb30494) 693169203



### 依赖安装
- Maven
```
<dependency>
    <groupId>org.thlws</groupId>
    <artifactId>payment-wechat</artifactId>
    <version>1.0.5</version>
</dependency>
```
- Gradle
```
compile 'org.thlws:payment-wechat:1.0.5'
```

### FAQ
#### 调用支付接口后，如何判断调用成功与否？
```
WechatPayResponse response = WechatPayClient.micropay(request,apiKey);
//flag == true 表示成功
boolean flag = response.isSuccess();
String  message = response.getMessage();
System.out.println("isSuccess="+flag+", message="+message);
```


### 全部支付
<b style="color:red">payment-*</b> 是一系列基于Java实现的支付类库，包含支付宝、微信、翼支付等，其目的是以最简单的方式完成各种支付方式接入。目前支付类库各自独立，使用时需单独引用，详见“支付类库”各自主页说明，后续不排除对所有支付类库整体打包，请留意文档更新。另源码会同时push到gitee&github,可能的话帮忙star下~😍
#### Gitee
- [https://gitee.com/thlws/payment-alipay](https://gitee.com/thlws/payment-alipay)
- [https://gitee.com/thlws/payment-wechat](https://gitee.com/thlws/payment-wechat)
- [https://gitee.com/thlws/payment-bestpay](https://gitee.com/thlws/payment-bestpay)   
#### Github
- [https://github.com/thlws/payment-alipay](https://github.com/thlws/payment-alipay)
- [https://github.com/thlws/payment-wechat](https://github.com/thlws/payment-wechat)
- [https://github.com/thlws/payment-bestpay](https://github.com/thlws/payment-bestpay)   