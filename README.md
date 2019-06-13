本仓库是Spring Cloud的使用案例仓库。
相关文章首发在我的个人网站：[https://yasinshaw.com](https://yasinshaw.com)

## 版本
- Java：JDK 11
- Spring Boot：2.1.5.RELEASE
- Spring Cloud：Greenwich.SR1
## 使用
启动命令：
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

### 微服务
所有微服务均运行在docker容器下。
当前只设置了service-order的8080端口映射，如需其他端口映射请修改docker-compose.yml

#### service-user
用户微服务：service-user
用户微服务启动了两个实例：
service-user-1
service-user-2

#### service-order
订单微服务：service-order
可通过 http://docker:8080/hello 访问。

service-order可通过feign访问**service-user**，可以通过 http://docker:8080/userHello 验证。

#### service-product
产品微服务：service-product