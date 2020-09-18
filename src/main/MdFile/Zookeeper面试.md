# zookeeper 面试相关

### 1.zookeeper原理？
    zookeeper的核型是原子广播，这个机制保证了各个server之间的同步，实现这个机制
    协议叫做ZAB协议，而ZAB有两种模式，分别是恢复模式和广播模式
    在服务启动或者在领导者崩溃后，ZAB就进入恢复模式，当领导者被选举出来，且大多数server
    完成和leader的状态同步后，恢复模式就结束了
    
    状态同步保证了 leader 和 server 具有相同的系统状态。一旦 leader 已经和多数的 follower 进行了状态同步后，
    他就可以开始广播消息了，即进入广播状态。这时候当一个 server 加入 zookeeper 服务中，它会在恢复模式下启动，
    发现 leader，并和 leader 进行状态同步。待到同步结束，它也参与消息广播。Zookeeper服务一直维持在 Broadcast 
    状态，直到 leader 崩溃了或者 leader 失去了大部分的followers 支持。广播模式需要保证 proposal 被按顺序处理，
    因此 zk 采用了递增的事务 id 号(zxid)来保证。所有的提议(proposal)都在被提出的时候加上了 zxid。
    
    实现中 zxid 是一个 64 为的数字，它高 32 位是 epoch 用来标识 leader 关系是否改变，每次一个 leader 被选出来
    ，它都会有一个新的 epoch。低 32 位是个递增计数。
    
    当 leader 崩溃或者 leader 失去大多数的 follower，这时候 zk 进入恢复模式，恢复模式需要重新选举出一个新的 leader，
    让所有的 server 都恢复到一个正确的状态。
    
### 2.zookeeper的角色？
    Leader：
        一个 Zookeeper 集群同一时间只会有一个实际工作的 Leader，它会发起并维护与各 Follwer及Observer间的心跳。
        所有的写操作必须要通过 Leader 完成再由 Leader 将写操作广播给其它服务器。
        只要有超过半数节点（不包括 observeer 节点）写入成功，该写请求就会被提交（类 2PC 协议）。
        
    Follower：一个 Zookeeper 集群可能同时存在多个 Follower，它会响应 Leader 的心跳；
              Follower 可直接处理并返回客户端的读请求，同时会将写请求转发给 Leader 处理；
              并且负责在 Leader 处理写请求时对请求进行投票。
              
    Observer：角色与 Follower 类似，但是无投票权。Zookeeper 需保证高可用和强一致性，为了支持更多的客户端，
              需要增加更多 Server；Server 增多，投票阶段延迟增大，影响性能；引入 Observer，Observer 
              不参与投票；Observers 接受客户端的连接，并将写请求转发给 leader 节点； 加入更多 Observer 节点，
              提高伸缩性，同时不影响吞吐率。
              
### 3.zookeeper可以实现那些功能？
    1.数据发布和订阅
    2.负载均衡
    3.命名服务
    4.分布式协调/通知
    5.集群管理
    6.Master选举
    7.分布式锁
    8.分布式队列
    
### 4.zookeeper可以保证那些分布式一致性？
    顺序一致性
    原子性
    单一视图
    可靠性
    实时性
    
### 5.zookeeper的数据模型？
    共享的，树形结构，由一系列的Znode数据节点组成，类似文件系统(目录不能存储数据)Znode存有数据信息，如版本号等等，
    ZNode之间的层级关系，像文件系统中的目录结构一样。并且他的数据是存在内存中，这样可以提高吞吐量，减少延迟

### 6.如何识别请求的先后顺序？
    ZooKeeper会给每一个更新请求，分配一个全局的递增编号，编号的大小体现事物操作的先后顺序

### 7.ZNode的类型？
    持久节点：一旦创建，除非手动移除，否则会一直保存在zookeeper中
    临时节点：生命周期和客户端会话绑定，会话失效，临时节点被移除
    持久顺序性：同时具备顺序性。
    临时顺序性：同时具备顺序性。
    
### 8.Stat记录了哪些版本相关数据？
    version:当前ZNode版本
    aversion:当前ZNode的ACL版本
   
### 9.zookeeper 定义了几种权限？
    create
    reade
    write
    delete
    admin
    
### 10.zookeeper专门设计了一种支持崩溃恢复的原子广播协议是？
    ZAB
    
### 11.ZAB的两种基本模式？
    奔溃恢复：在正常情况下运行非常良好，一旦leader出现崩溃或者由于网络原因导致leader服务器失去了与过半Follower的联系
    那么就会进入崩溃恢复模式。为了程序的正确运行，整个恢复过程后需要选举出一个新的Leader,因此需要一个高效可靠的选举
    方法快速选举出一个Leader。
    
    消息广播：类似一个两阶段提交过程，针对客户端的事务请求， Leader服务器会为其生成对应的事务Proposal,并将其
    发送给集群中的其余所有机器，再分别收集各自的选票，最后进行事务提交。
    
### 12.哪些情况会导致ZAB进入恢复模式并选取新的Leader
    启动过程或者Leader出现网络中断，崩溃退出或者重启情况
    当选举出新的leader后，同时集群中已经有过半的机器与该leader服务器完成了状态同步之后,ZAB就会退出恢复模式
    
### 13.什么是会话Session?
    指的是客户端会话，客户端启动时候，会与服务器建立TCP连接，连接成功后，客户端的生命周期开始，客户端和服务器通过心跳检测保持
    有效的的会话以及发请求并响应、监听Watch事件等。
    
### 14.Watcher事件监听器？
    ZooKeeper允许用户在指定节点上注册Watcher,当触发特定事件时，ZooKeeper服务端会把相应的事件通知到相应的客户端上，
    属于ZooKeeper一个重要的特性。
    
### 15.同进程组的两个进程消息网络通信有哪两个特性？
    完整性：如果进程a收到进程b的消息msg,那么b一定发送了消息msg。
    前置性：如果msg1是msg2的前置消息，那么当前进程务必先接收到msg1,在接受msg2。

### 16.ZAB的三阶段？
    发现 (Discovery)
    同步 (Synchronization)
    广播 (Broadcast)

### 17.客户端如何获取配置信息？
    启动时主动到服务端拉取信息，同时，在制定节点注册Watcher监听。一旦有配置变化，服务端就会实时通知订阅它的所有客户端。