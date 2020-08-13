### 1：什么是控制反转？什么是依赖注入？
    控制反转：IOC-Inversion of Control；控制反转是一种设计思想，不是一种技术，
            Ioc意味着将你设计好的对象交给容器控制，而不是传统的在你的对象内部直接控制
            
### 2：spring有哪几种注入方式？
    1.构造注入
    2.set注入
    3.注解
    
### 2：BeanFactory和ApplicationContext有什么区别？
    BeanFactory和ApplicationContext是Spring的两大核心接口，
    都可以当做Spring的容器。其中ApplicationContext是BeanFactory的子接口。
    
    BeanFactory是spring最底层的一个接口，包含了各种bean的定义，包括：读取bean的配置文件，
    管理bean 的加载，实例化，控制bean的生命周期，维护bean的依赖关系
    
    ApplicationContext：他是在启动的时，一次性创建了所有的bean，这样在容器启动的时候，我们可以发现，spring
    中存在配置错误，这样利于检查所有所有依赖是否注入，ApplicationContext启动后，预载入所有单利的bean，通过预载入单实例bean ，
    确保当你需要的时候，你就不用等待，因为它们已经创建好了。
    
    
    相对于基本的BeanFactory，ApplicationContext唯一不足的地方是，占用内存空间。当应用程序配置Bean较多时，程序启动较慢。
    
### 3：将Spring配置到你项目中有哪几种方式方式？