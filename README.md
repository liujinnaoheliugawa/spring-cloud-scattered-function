# Spring Cloud 生态的零散组件



## 项目目的

记录 Spring Cloud 生态中零散组件的工作模式



## 项目组件

### Server

只有配置文件，通过 Git + Config Client @RefreshScope 动态变更 Config Server 上的配置



### Config Client

与 Server 共同使用，提供接口查看 Config Server 上配置文件的中配置的值



### Eureka Client

作为 Eureka Server 的客户端提供向 Eureka Server 注册相应服务



### Eureka Server

注册中心服务器，可做集群



### Hystrix Client

熔断的集中实现方式



### Hystrix Dashboard

熔断信息跟踪仪表盘



### Stream Kafka

Kafka 生产/消费的集中实现形式

