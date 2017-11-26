## 详细教程
- 文档：[http://payment-wechat.mydoc.io/](http://payment-wechat.mydoc.io/)

## 项目说明
1. 用于微信支付，基于Java语言实现的依赖库；
2. 接口参数全部封装，使用者仅需创建对象并设置参数；
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
- 能不能直接 dependency 添加依赖?<br>
_暂时还不行，正在想办法发布到共有仓库._

- Android是否可以使用?<br>
_未测试不太确定，该项目并非针对Android设计，建议Android使用微信App支付方式_

- 该项目到底支持哪几种微信支付？<br>
_目前没有全部支持微信官方的支付方式,截止目前支持 公众号支付、刷卡支付、扫码支付 三种支付方式._
