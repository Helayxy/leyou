# leyou

**乐优商城介绍**
乐优商城是一个全品类的电商购物网站（B2C）。
用户可以在线购买商品、加入购物车、下单
可以评价已购买商品
管理员可以在后台管理商品的上下架
管理员可以监控商品销售状况

**相关技术**

前端技术：
- 基础的HTML、CSS、JavaScript（基于ES6标准）
- Vue.js 2.0以及基于Vue的UI框架：Vuetify
- 前端构建工具：WebPack
- 前端安装包工具：NPM
- Vue脚手架：Vue-cli
- Vue路由：vue-router
- ajax框架：axios
- 基于Vue的富文本框架：quill-editor

后端技术：
- 基础的SpringMVC、Spring 5.0和MyBatis3
- Spring Boot 2.0.1版本
- Spring Cloud 最新版 Finchley.RC1
- Redis-4.0
- RabbitMQ-3.4
- Elasticsearch-5.6.8
- nginx-1.10.2
- FastDFS - 5.0.8
- MyCat
- Thymeleaf
- JWT

**上面的技术组合可以在项目中解决以下电商中的典型问题：**

- 利用Node.js及Vue.js技术栈，实现前后端分离开发
- 利用SpringCloud技术栈，实现真正的微服务实战开发，并且是基于SpringBoot2.0和SpringCloud最新版本Finchley.RC1实现，业内领先。
- 贴近真实的电商数据库设计，解决全品类电商的SPU和SKU管理问题
- 基于FastDFS解决大数据量的分布式文件存储问题
- 基于Elasticsearch高级聚合功能，实现商品的智能过滤搜索
- 基于Elasticsearch高级聚合功能，实现销售业务的复杂统计及报表输出
- 基于LocalStorage实现离线客户端购物车，减轻服务端压力。
- 基于JWT技术及RSA非对称加密实现真正无状态的单点登录。
- 结合JWT和RSA非对称加密，自定义Feign过滤器实现自动化服务间鉴权，解决服务对外暴露的安全问题
- 基于阿里大于实现SMS功能，解决电商短信通知问题
- 基于RabbitMQ实现可靠消息服务，解决服务间通信问题
- 基于RabbitMQ实现可靠消息服务，解决分布式事务问题
- 使用微信SDK实现微信扫码支付，符合主流付款方式
- 基于Redis搭建高可用集群，实现可靠缓存服务即热点数据保存。
- redis持久化，集群，哨兵，主从，缓存击穿，热点key。
- 基于Redis和Mq来应对高可用高并发的秒杀场景
- 基于MyCat实现数据库的读写分离和分库分表
- 基于Thymeleaf实现页面模板和静态化，提高页面响应速度和并发能力
- 基于Nginx实现初步的请求负载均衡和请求限流
