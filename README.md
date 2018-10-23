微信支付
============
[![](https://img.shields.io/badge/release-v1.0.3-blue.svg)](https://github.com/thlws/payment-wechat)   [![](https://img.shields.io/badge/license-Apache--2-yellowgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0.html) [![](https://img.shields.io/badge/maven%20central-v1.0.3-brightgreen.svg)](https://search.maven.org/artifact/org.thlws/payment-wechat/1.0.3/jar) 

> 基于Java实现的 微信支付 依赖库。

### 功能说明
1. 用于微信支付，基于Java语言实现的依赖库；
2. 接口参数全部封装，使用者仅需创建对象并设置参数；
3. 项目极少依赖，接口简单清晰，日志详细且输出格式友好；
4. 示例详细且简单易懂，文档全面，大大降低微信支付接入门槛；


### 更新日志
- v1.0.0 微信支付依赖库正式发布;
- v1.0.1 新增公众号支付时,token 和 open_id 获取接口;
- v1.0.2 修正Junit测试,增加Javadoc注释内容;
- v1.0.3 新增公众号支付示例代码,升级依赖库hutool;



### 在线文档
- [ 使用手册 ](http://payment-wechat.mydoc.io/)   
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
    <version>1.0.3</version>
</dependency>
```
- Gradle
```
compile 'org.thlws:payment-wechat:1.0.3'
```


### 全部支付
<b style="color:red">payment-*</b> 是一系列基于Java实现的支付类库，包含支付宝、微信、翼支付等，其目的是以最简单的方式完成各种支付方式接入。
目前支付类库各自独立，使用时需单独引用，详见“支付类库”各自主页说明，后续不排除对所有支付类库整体打包，请留意文档更新。
- [https://gitee.com/thlws/payment-alipay](https://gitee.com/thlws/payment-alipay)
- [https://gitee.com/thlws/payment-wechat](https://gitee.com/thlws/payment-wechat)
- [https://gitee.com/thlws/payment-bestpay](https://gitee.com/thlws/payment-bestpay)   
