### 乐优商城介绍

#### 一、项目介绍：

- 乐优商城是一个全品类的电商购物网站（B2C）。
- 用户可以在线购买商品、加入购物车、下单、秒杀商品
- 可以品论已购买商品
- 管理员可以在后台管理商品的上下架、促销活动
- 管理员可以监控商品销售状况
- 客服可以在后台处理退款操作
- 希望未来3到5年可以支持千万用户的使用

#### 二、系统架构

##### 1.系统架构图：

![](C:/Users/Administrator/Desktop/%E4%B9%90%E4%BC%98%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B/assets/lysc.png)

##### 2.系统架构解读：

整个乐优商城可以分为两部分：后台管理系统、前台门户系统。

###### 后台管理系统：

- 后台系统主要包含以下功能：
  - 商品管理，包括商品分类、品牌、商品规格等信息的管理
  - 销售管理，包括订单统计、订单退款处理、促销活动生成等
  - 用户管理，包括用户控制、冻结、解锁等
  - 权限管理，整个网站的权限控制，采用JWT鉴权方案，对用户及API进行权限控制
  - 统计，各种数据的统计分析展示
- 后台系统会采用前后端分离开发，而且整个后台管理系统会使用Vue.js框架搭建出单页应用（SPA）。
- 后台管理系统预览图：

![](C:/Users/Administrator/Desktop/%E4%B9%90%E4%BC%98%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B/assets/02.png)

###### 前台门户系统：

- 前台门户面向的是客户，包含与客户交互的一切功能。例如：
  - 搜索商品
  - 加入购物车
  - 下单
  - 评价商品等
- 前台系统我们会使用Nuxt结合Vue完成页面开发。出于SEO优化的考虑，我们将不采用单页应用。
- 后台管理系统预览图：

![](C:/Users/Administrator/Desktop/%E4%B9%90%E4%BC%98%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B/assets/03.png)

#### 三、项目结构：

##### 1.后台微服务目录结构图：

![](C:/Users/Administrator/Desktop/%E4%B9%90%E4%BC%98%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B/assets/08.png)

##### 2.后台微服务结构图及介绍：

![](C:/Users/Administrator/Desktop/%E4%B9%90%E4%BC%98%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B/assets/07.png)

无论是前台还是后台系统，都共享相同的微服务集群，共11个微服务，如下所示：

- 商品微服务（LeyouItemServiceApplication）：实现商品及商品分类、品牌、库存等功能
- 搜索微服务（LeyouSearchApplication）：实现搜索功能
- 订单微服务（LeyouOrderApplication）：实现订单相关功能
- 购物车微服务（LeyouCartApplication）：实现购物车相关功能
- 图片上传微服务：（LeyouUploadApplication）：实现文件上传功能
- 页面静态化微服务：（LeyouGoodsWebApplication）：实现商品详情页的页面静态化功能，提高响应速度
- 消息微服务（LeyouSmsApplication）：实现用户注册、登录时短信、验证码等功能
- 用户中心（LeyouUserApplication）：实现用户的登录注册等功能
- 认证中心（LeyouAuthApplication）：实现用户权限及服务权限认证功能
- Eureka注册中心（LeyouRegisterApplication）：实现对微服务的统一管理功能
- Zuul网关服务（LeyouGatewayApplication）：实现对所有微服务的保护功能

#### 四、技术选型：

##### 1.相关技术：

###### 前端技术：

- 基础的HTML、CSS、JavaScript（基于ES6标准）
- Vue.js 2.0以及基于Vue的UI框架：Vuetify
- 前端构建工具：WebPack
- 前端安装包工具：NPM
- Vue脚手架：Vue-cli
- Vue路由：vue-router
- ajax框架：axios
- 基于Vue的富文本框架：quill-editor

###### 后端技术：

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

##### 2.技术分析：

上面的技术组合可以在项目中解决以下电商中的典型问题：

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

  redis持久化，集群，哨兵，主从，缓存击穿，热点key。

- 基于Redis和Mq来应对高可用高并发的秒杀场景

- 基于MyCat实现数据库的读写分离和分库分表

  发视频

- 基于Thymeleaf实现页面模板和静态化，提高页面响应速度和并发能力

- 基于Nginx实现初步的请求负载均衡和请求限流

#### 五、项目启动、访问流程：

##### 1.乐优项目文件介绍：

![](C:/Users/Administrator/Desktop/%E4%B9%90%E4%BC%98%E9%A1%B9%E7%9B%AE%E7%AE%80%E4%BB%8B/assets/01.png)

##### 2.启动elasticsearch服务器：

进入虚拟机，使用命令su - leyou切换到leyou用户，使用命令cd elasticsearch/bin进入该目录，使用./elasticsearch启动elasticsearch服务；

##### 3.启动后台所需微服务：

需要启动的微服务有以下几个：

- LeyouRegisterApplication：Eureka注册中心
- LeyouGatewayApplication：Zuul网关服务
- LeyouItemServiceApplication：商品微服务
- LeyouSearchApplication：搜索微服务
- LeyouGoodsWebApplication：页面静态化微服务

##### 4.启动后台管理系统（leyou-manage-web工程）：在IDEA中的命令行窗口，也就是Terminal窗口输入命令：

```shell
npm start
```

在浏览器中输入http://manage.leyou.com进行访问；

##### 5.启动前段门户网站（leyou-protal工程）:在IDEA中的命令行窗口，也就是Terminal窗口输入命令：

```shell
live-server  --port=9002
```

在浏览器中输入http://www.leyou.com进行访问；

#### 六、总结

##### 1.nginx配置：

之所以可以使用http://manage.leyou.com和http://www.leyou.com进行访问，是因为我们使用了nginx反向代理，nginx的配置文件如下所示：

```nginx
#以下为乐优项目配置
server {
    listen       80;
    server_name  www.leyou.com;

    proxy_set_header X-Forwarded-Host $host;
    proxy_set_header X-Forwarded-Server $host;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;

    location /item {
       # 先找本地
       #root html;
       #if (!-f $request_filename) { #请求的文件不存在，就反向代理
           proxy_pass http://127.0.0.1:8084;
       #   break;
       #}
    }
	
	location / {
        proxy_pass http://127.0.0.1:9002;
        proxy_connect_timeout 600;
        proxy_read_timeout 600;
    }
}

server {
    listen       80;
    server_name  manage.leyou.com;

    proxy_set_header X-Forwarded-Host $host;
	proxy_set_header X-Forwarded-Server $host;
	proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
	
	location / {
		proxy_pass http://127.0.0.1:9001;
		proxy_connect_timeout 600;
		proxy_read_timeout 600;
	}
}

server {
    listen       80;
    server_name  api.leyou.com;

    proxy_set_header X-Forwarded-Host $host;
    proxy_set_header X-Forwarded-Server $host;
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
	proxy_set_header Host $host;
	
	# 上传路径的映射
	location /api/upload {	
		proxy_pass http://127.0.0.1:8082;
		proxy_connect_timeout 600;
		proxy_read_timeout 600;
		
		rewrite "^/api/(.*)$" /$1 break; 
    }

    location / {
		proxy_pass http://127.0.0.1:10010;
		proxy_connect_timeout 600;
		proxy_read_timeout 600;
    }
}
```

##### 2.switchhost配置如下所示：

```shell
127.0.0.1 api.leyou.com
127.0.0.1 manage.leyou.com
192.168.56.101 image.leyou.com
127.0.0.1 www.leyou.com
```

##### 3.注意事项：

- 在C:\tmp\rsa目录下需要有rsa.pri和rsa.pub两个文件；
- 本项目生成的商品详情页静态页面位于C:\tools\nginx-1.14.0\html\item目录下。

