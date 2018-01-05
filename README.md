## 更新日志
- v1.0.0 微信支付依赖库正式发布;
- v1.0.1 新增公众号支付时,token 和 open_id 获取接口;
- v1.0.2 修正Junit测试,增加Javadoc注释内容;


## 详细教程
- 文档：[http://payment-wechat.mydoc.io/](http://payment-wechat.mydoc.io/)

## 项目说明
1. 用于微信支付，基于Java语言实现的依赖库；
2. 接口参数全部封装，使用者仅需创建对象并设置参数；
3. 项目极少依赖，接口简单清晰，日志详细且输出格式友好；
4. 示例详细且简单易懂，文档全面，大大降低微信支付接入门槛；

## 依赖安装
- Maven
```
<dependency>
    <groupId>org.thlws</groupId>
    <artifactId>payment-wechat</artifactId>
    <version>1.0.2</version>
</dependency>
```
- Gradle
```
compile 'org.thlws:payment-wechat:1.0.2'
```

## 源码测试
1. ```git clone https://github.com/thlws/payment-wechat.git```
2. 导入到 Eclipse 或 Intellij IDEA
3. 运行 Junit Class WechatClientTest (微信支付相关接口)
4. 运行 Junit Class WechatOfficialTest （公众号开发相关接口）

## 项目依赖
- [http://www.hutool.cn](http://www.hutool.cn)
- [http://x-stream.github.io](http://x-stream.github.io)
- [https://github.com/google/gson](https://github.com/google/gson)

## FAQ
- 能不能直接 dependency 添加依赖?<br>
_已发布至公有仓库，添加方式如上._

- Android是否可以使用?<br>
_未测试不太确定，该项目并非针对Android设计，建议Android使用微信App支付方式._

- 该项目到底支持哪几种微信支付？<br>
_目前没有全部支持微信官方的支付方式,截止目前支持 公众号支付、刷卡支付、扫码支付 三种._

- 有没有小微支付相关文档？<br>
_[小微支付介绍](https://gitee.com/thlws/payment-wechat/raw/master/docs/%E5%B0%8F%E5%BE%AE%E6%94%AF%E4%BB%98%E4%BB%8B%E7%BB%8D-wechat%20micro%20pay_1475134908_3aO.pdf)_ <br>
_[微信收款（个人转账版）服务接口](https://gitee.com/thlws/payment-wechat/raw/master/docs/%E5%BE%AE%E4%BF%A1%E6%94%B6%E6%AC%BE%EF%BC%88%E4%B8%AA%E4%BA%BA%E8%BD%AC%E8%B4%A6%E7%89%88%EF%BC%89%E6%9C%8D%E5%8A%A1%E6%8E%A5%E5%8F%A3%E6%96%87%E6%A1%A3-20170222.pdf)_


## 打赏一下
![](imgs/award.png)
