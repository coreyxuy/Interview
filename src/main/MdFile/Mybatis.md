### 1.#{} 和 ${} 的区别是什么？
    ${}是Properties文件中的变量占位符，他可以用在标签属性值和sql内部，属于静态文件替换，比如${driver}会被静态替换为com.mysql.jdbc.Driver。即字符串拼接
    #{}是sql的参数占位符，mybatis会将sql中的#{}替换为?,在sql执行前会使用PreparedStatement的参数设置方法，按序给sql的？设置参数 即为预编译处理

### 2.xml映射文件除了常见的update｜inster｜delete｜select｜标签之外还有什么标签？
    还有如：<resultMap>,<parameterMap>,<sql>,<include>,<selectKey>

### 3.在项目中，一般情况下xml映射文件，都会写一个dao接口与之对应，请问这个dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗？
    dao接口是我们常说的mapper接口，接口的权限名称，就是映射文件的namespace的值，接口的方法名称就是MappedStatement的id值，
    接口方法内的参数，是传递给sql的参数
    
    mapper接口没有实现类，当调用接口方式时候，接口权限名称，+方法名拼接字符串作为key值，可唯一定位一个MappedStatement，
    com.mybatis3.mappers.StudentDao.findStudentById，可以唯一找到namespace为com.mybatis3.mappers.StudentDao下面id = findStudentById
    的MappedStatement。在Mybatis中，每一个<select>、<insert>、<update>、<delete>标签，都会被解析为一个MappedStatement对象。
    
    dao接口里的方式是不能被重载的，因为是权限名称加方法名称的保存寻找策略
    
    dao接口的工作原理是jdk的动态代理模式，mybatis运行时会使用jdk的动态代理为dao接口生成代理的proxy代理对象，代理对象会拦截接口方法，
    转而执行MappedStatement所代表的sql，然后将sql执行的结果返回

### 4.mybatis是如何进行分页的？分页插件的原理是什么？
    mybatis使用RowBounds进行分页的，它是针对resultSet结果集针对的内存分页，而非物理分页，以在sql内直接书写带有物理分页的参数来完成物理分页功能，
    也可以使用分页插件来完成物理分页。
    
    分页插件使用的基本原理是Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，
    添加对应的物理分页语句和物理分页参数。
    
    如：select * from student，拦截sql后重写为：select t.* from （select * from student）t limit 0，10
   