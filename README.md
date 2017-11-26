## 详细教程
- 文档：[http://payment-wechat.mydoc.io/](http://payment-wechat.mydoc.io/)

## 项目说明
1. 用于微信支付，基于Java语言实现的依赖库；
2. 接口参考全部封装，使用者仅需要创建对象并设置参数；
3. 项目极少依赖，接口简单清晰，日志详细且输出格式友好；
4. 示例详细且简单易懂，文档全面，大大降低微信支付接入门槛；


## 源码测试
1. ```git clone https://github.com/thlws/payment-wechat.git```
2. 导入到eclipse或Intellij IDEA
3. 运行 Junit Class WechatClientTest

## 项目依赖
- [http://www.hutool.cn](http://www.hutool.cn)
- [http://x-stream.github.io](http://x-stream.github.io)
- [https://github.com/google/gson](https://github.com/google/gson)

## FAQ
- 为什么公众号上没有微信支付(线上)?
_微信公众号支付在微信网页完成的,支付前需要调用统一下单接口._

- 微信支付到底有几种方式?
_微信官方支付方式包括:公众号支付、扫码支付、刷卡支付、H5支付._

- 该项目到底支持哪几种微信支付？
_目前没有全部支持微信官方的支付方式,截止目前支持 公众号支付、刷卡支付、扫码支付 三种支付方式._

- 扫码支付后续是否可以提供AllInOne的支付API?
_不可以,扫描支付与公众号支付类似,是在用户手机上完成支付的,支付前需要调用统一下单接口._
