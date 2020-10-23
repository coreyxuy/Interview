# mysql
### 1.链接mysql命令
    mysql -u root -p
    输入密码

### 2.什么是长链接，什么是短链接？
    数据库里，长链接是连接成功，如果客户端持续有请求，则一直使用这个链接
    数据库里，短链接是次执行完很少的几次查询就断开连接，下次查询重新建立一个

### 3.为什么大多情况下，都不建议查询缓存？
    1.查询缓存的失效率非常频繁，只要有一个表更新，这个表上的缓存就要被更新清空
    2.对于更新压力大的数据库来说，查询缓存的命中率会非常低
    3.除非你的业务就是一张静态表，很长时间才会更新一次（如：系统配置表）
    不查询缓存的方式：
        query_cache_type 设置成 DEMAND
    确定需要查询缓存的语句
        select SQL_CACHE * from T where ID=10；
    
### 4.GROUP_CONCAT 函数介绍;
    group_concat([DISTINCT] 要连接的字段 [Order BY ASC/DESC 排序字段] [Separator '分隔符'])

### 5.DISTINCT函数用法
    在表中，可能会包含重复值。这并不成问题，不过，有时您也许希望仅仅列出不同（distinct）的值。
    关键词 DISTINCT 用于返回唯一不同的值。
    SELECT DISTINCT 列名称 FROM 表名称
    
### 6.MySQL的常用存储引擎及他们之间的区别？
    MyISAM是mysql默认的存储引擎(5.5版本之前)，虽然性能高，而且提供了大量的特性，包括前文索引，压缩，空间函数，但是myisam不支持事物和
    行锁，而且最大的缺陷是崩溃后无法安全恢复，不过5.5版本之后，mysql引入了InnoDB（事物性数据引擎）MySQL 5.5版本后默认的存储引擎为InnoDB。
    两个对比较：
        myisam只有支持表级锁，而innodb只支持行级锁，
        MyISAM强调的是性能，每次的查询都具有原子性，其执行速度比InnoDB类型的更加快，但是不提供事物支持，但是InnoDB提供
        事物支持，外部键等高级功能，具有事物（commit）和回滚（rollback）和崩溃修复功能，
        是否支持外键：仅 InnoDB 支持，应对高并发事物，mvcc比单纯的加锁更高效;MVCC只在 READ COMMITTED 和 
        REPEATABLE READ 两个隔离级别下工作;MVCC可以使用 乐观(optimistic)锁 和 悲观(pessimistic)锁来实现;
        各数据库中MVCC实现并不统一。
        推荐阅读：MySQL-InnoDB-MVCC多版本并发控制
    
### 8.MySQL索引的实现机制是什么，为什么要使用B+树？
    官方文档上说：索引（index）是帮助mysql高效的获取数据的数据结构
    本质：索引是数据结构
        

    

### 9.MySQL中的事务实现原理？

### 10.MySQL有哪些常用的优化策略？
    
### 6.描述下MySQL的架构体系？