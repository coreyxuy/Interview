# dubbo

### 1.什么是dubbo
    是一款高性能，轻量级的开源java RPC框架，提供了三大核心功能，面向接口的远程方法调用，智能容错和负载均衡，服务自动注册，发现，
    简单的来说，dubbo是一款分布式服务框架，致力于提供高性能和透明化的RPC远程服务调用方案，以及SOA服务治理方案。

    
### 1.dubbo如何优雅停机的？
    dubbo是通过JDK的shutdownHook来完成优雅停机的，所以如果使用kill -9 PID 等强制关闭指令来关闭服务，是不会执行优雅停机的，
    只能通过kill pid 时候才能优雅停机
    
### 2.你觉得dubbo好还是springcloud好？
    只有适合不适合的问题，框架没有好坏
    
### 3.dubbo需要web容器吗？
    不需要
    
### 4.dubbo 内置哪几种容器？
    Spring Container
    Jetty Container
    Log4j Container
    Dubbo 的服务容器只是一个简单的 Main 方法，并加载一个简单的 Spring 容器，用于暴露服务。

### 5.dubbo 默认使用的注册中心是什么？有哪些注册中心？
    推荐使用 Zookeeper 作为注册中心
    注册中心还有：redis，Multicast，Simple 推荐使用zk

### 6.什么是负载均衡？
    负载平衡旨在优化资源使用，最大化吞吐量，最小化响应时间，并避免任何单个资源的过载。
    使用具有负载平衡而不是单个组件的多个组件可以通过冗余提高可靠性和可用性。负载平衡通常涉及专用软件或硬件。
    
### 7.Dubbo 提供的负载均衡策略？
    Dubbo 提供了多种负载均衡策略，默认为random 随机调用
    1.Random LoadBalance 默认，基于权重的随机负载均衡策略
    2.RoundRobin LoadBalance 权重轮询负载均衡
    3.LeastActive LoadBalance 最少活跃调用数，相同活跃数的随机，活跃数指调用前后计数差
    4.ConsistentHash LoadBalance 一致性Hash，相同参数的请求总是发到同一提供者
    (如果你需要的不是随机负载均衡，是要一类请求都到一个节点，那就走这个一致性hash策略。)
    
### 8.zookeeper宕机与dubbo直连的情况
    加入zookeeper注册中心宕机，一段时间内，服务注册方，还是能够调用提供方的服务的，实际上使用的是本地缓存来
    调用的，
    
    Dubbo的健壮性表现有哪些？
    1.监控中心宕掉不影响使用，只是丢失部分采样数据
    2.数据库宕掉后，注册中心仍能通过缓存提供服务列表查询，但不能注册新服务
    3.注册中心对等集群，任意一台宕掉后，将自动切换到另一台
    4.注册中心全部宕掉后，服务提供者和服务消费者仍能通过本地缓存通讯
    5.服务提供者无状态，任意一台宕掉后，不影响使用
    6.服务提供者全部宕掉后，服务消费者应用将无法使用，并无限次重连等待服务提供者恢复
 
### 9.Dubbo默认使用什么通讯框架？
    Dubbo 默认使用 Netty 框架，也是推荐的选择，另外内容还集成有Mina、Grizzly。
    
### 10.Dubbo 有哪几种容错方案？
    1.Failover Cluster   失败自动切换，自动重试其他服务器
    2.Failfast Cluster   快速失败，立即报错，只发起一次调用
    3.Failsafe Cluster   失败安全，出现异常时，直接忽视
    4.Failback Cluster   失败自动恢复，记录失败请求定时重发
    5.Forking  Cluster   并行调用多个服务，只要一个成功就返回
    6.BroadcastCluster   广播逐个调用所有提供者，任意一个报错则全部报错

### 10.Dubbo 服务暴露的过程？
    Dubbo会在spring实例化完 bean 之后 ，在刷新容器最后一步发布ContextRefreshEvent 事件的时候
    通知实现，ApplicationListener的ServiceBean类进行回调 onApplicationEvent 事件方法，
    Dubbo 会在这个方法中调用 ServiceBean 父类 ServiceConfig 的 export 方法，
    而该方法真正实现了服务的（异步或者非异步）发布。

### 11.dubbo 服务调用是阻塞的吗？
    默认是阻塞的，可以异步调用，Dubbo 是基于 NIO 的非阻塞实现并行调用，
    客户端不需要启动多线程即可完成并行调用多个远程服务，相对多线程开销较小，
    异步调用会返回一个 Future 对象。
    
### 12.dubbo 推荐使用什么协议？
    dubbo://（推荐）
    rmi://
    hessian://
    http://
    webservice://
    thrift://
    redis://
    rest://
    memcached://

### 13.Dubbo 服务降级，失败重试怎么做？
    可以通过dubbo:reference 中设置 mock=“return null”。mock 的值也可以修改为 true，
    然后再跟接口同一个路径下实现一个 Mock 类，
    命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑
    
### 14.Dubbo 配置文件是如何加载到Spring中的？
    Spring容器在启动的时候，会读取到Spring默认的一些schema以及Dubbo自定义的schema，
    每个schema都会对应一个自己的NamespaceHandler，NamespaceHandler里面通过
    BeanDefinitionParser来解析配置信息并转化为需要加载的bean对象！
   
### 15.Dubbo SPI 和 Java SPI 区别？
    JDK SPI ：JDK 标准的 SPI 会一次性加载所有的扩展实现，如果有的拓展初始化很耗时的话，
    但也没用上，就很浪费资源。所以只希望加载某个的实现，就不现实了 
    
    DUBBO SPI：对Dubbo进行扩展，不需要改动Dubbo的源码，
               延迟加载，可以一次只加载自己想要加载的扩展实现
               增加了对扩展点 IOC 和 AOP 的支持，一个扩展点可以直接 setter 注入其它扩展点。
               Dubbo的扩展机制能很好的支持第三方IoC容器，默认支持Spring Bean。
               
     
### 17.Dubbo支持哪些序列化方式？
    dubbo支持hession，Java 二进制序列化，json，SOAP 默认序列化协议
    

### 18. Dubbo和SpringCloud的关系？
    dubbo 是基于 dubbo协议
    而springcloud是基于 http协议的
    本质上其实不存在对比性

### 19.Dubbo的主要应用场景？
    1：Rpc 分布式分布式服务
    2：配置管理
    3：服务依赖
    4：服务扩容
    
### 20.什么是RPC协议？
    RPC(Remote Procedure Call Protocol) 远程过程调用协议，它是一种通过网络从远程计算机程序上请求服务，而不需要
    了解底层网络技术的协议，简而言之，RPC使得程序能够访问本地系统资源一样，去访问远程资源，
    
### 20.服务调用超时问题怎么解决？
     dubbo reference 设置timeout 超时时间

    
      
    

    
        
