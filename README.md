## 支付方式
- 公众号支付
- 刷卡支付
- 扫码支付

## 商户模式
- 普通商户
- 子商户（服务商下建立）
- 小微商户(服务商下建立,不支持退款，官方暂无文档)

## 源码测试
1. ```git clone https://github.com/thlws/payment-wechat.git```
2. 导入到eclipse或Intellij IDEA
3. 运行 Junit Class WechatClientTest

## 项目依赖
_payment-wechat 中已将所有依赖打包._
* 工具包
```
<dependency>
    <groupId>com.xiaoleilu</groupId>
    <artifactId>hutool-all</artifactId>
    <version>3.2.1</version>
</dependency>
```

* XML解析
```
<dependency>
    <groupId>com.thoughtworks.xstream</groupId>
    <artifactId>xstream</artifactId>
    <version>1.4.10</version>
</dependency>
```
* JSON解析
```
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.2</version>
</dependency>
```

* 二维码
```
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>core</artifactId>
    <version>3.3.1</version>
</dependency>
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>javase</artifactId>
    <version>3.3.1</version>
</dependency>
```

## FAQ
 
 Q1:为什么公众号上没有微信支付(线上)?
 A1:微信公众号支付在微信网页完成的,支付前需要调用统一下单接口.

 Q2:微信支付到底有几种方式?
 A2:微信官方支付方式包括:公众号支付、扫码支付、刷卡支付、H5支付.

 Q3:该项目到底支持哪几种微信支付？
 A3:目前没有全部支持微信官方的支付方式,截止目前支持 公众号支付、刷卡支付、扫码支付 三种支付方式.

 Q4:扫码支付后续是否可以提供AllInOne的支付API?
 A4:不可以,扫描支付与公众号支付类似,是在用户手机上完成支付的,支付前需要调用统一下单接口.
