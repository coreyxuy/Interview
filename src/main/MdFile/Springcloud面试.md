### 1.eureka和zookeeper的区别？
    CAP 理论：一致性：Consistency
             可用性：Availability
             分区错容性：Partition tolerance	
    
    eureka基于Ap：可用性和和分区错容性
    zookeeper基于：CP：一致性和分区错容性
    
### 2.什么是Ribbon？
    Ribbon是客户端提供负载均衡的功能的服务，
    它内部提供了一个叫做ILoadBalance的接口代表负载均衡器的操作，负载均衡器
        
### 3.到底什么是RestTemplate？
    REST是一种互联网的系统架构风格，RestTemplate字面意思就是支持Rest风格的互联网请求方式模版，他是一种支持
    REST风格并简化了发起http请求访问资源的以及处理响应的方式，REST 指的是一组架构约束条件和原则。满足这些约束条件和原则的应用程序或设计就是 RESTful。
    而Restful接口就是给一个外部系统提供访问当前系统的一个方法。
 