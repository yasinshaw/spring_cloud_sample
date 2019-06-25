本仓库是Spring Cloud的使用案例仓库。
相关文章首发在我的个人网站：[https://yasinshaw.com](https://yasinshaw.com)

## 版本
- Java：JDK 11
- Spring Boot：2.1.5.RELEASE
- Spring Cloud：Greenwich.SR1
## 使用
本地启动所有容器：
```bash
./start.sh
```
清除资源：
```bash
./stop.sh
```
## 组件

### 服务注册中心
服务注册中心使用Consul，可以去[官网下载](https://www.consul.io/downloads.html)
使用默认端口号，Web界面端口是8500。

### 网关
网关使用了Spring Cloud Gateway组件，对容器外部暴露的端口号是8081。可通过 http://docker:8081/service-user/hello测试访问。

### 配置中心
网关使用了Spring Cloud Config组件，对容器外部暴露的端口号是8082。可通过 http://docker:8082/service-user/default测试访问。

配置代码在git仓库：[https://github.com/yasinshaw/spring_cloud_sample_config](https://github.com/yasinshaw/spring_cloud_sample_config)

本demo在本地启动了gogs实例，用于模拟githook自动触发配置刷新。所以你可能需要将上述仓库克隆下来，再push到gogs容器里面。

访问gogs：[http://docker:10080](http://docker:10080)

数据库类型可以选择 SQLite3,域名 gogs，应用URL http://gogs:3000/

配置好后，打开[http://docker:10080/user/login](http://docker:10080/user/login)注册账号：
- 用户名 springcloud
- 密码 springcloud

然后创建新的仓库spring_cloud_sample_config，然后将本地的配置文件push上去：

```bash
git remote add gogs http://docker:10080/springcloud/spring_cloud_sample_config.git
git push -u gogs master
```
输入用户名springcloud和密码springcloud。

然后在仓库设置里面创建Web钩子：
http://config:8080/myRefresh

### 微服务
所有微服务均运行在docker容器下。
当前只设置了service-order的8080端口映射，如需其他端口映射请修改docker-compose.yml

#### 用户微服务：service-user
用户微服务启动了两个实例：
- service-user-1
- service-user-2

详情请查看docker-compose文件
#### 订单微服务：service-order
可通过 http://docker:8080/hello 访问。

service-order可通过**Feign**访问**service-user**，可以通过 http://docker:8080/userHello 验证。

#### 产品微服务：service-product
只有一个实例
