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
              
### 3.zookeeper的角色？
    