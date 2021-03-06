# 2019/04/15-2019/04/17  jdk1.8 Redis Mongodb
 > 作业 [springboot_redis_mongodb_homework](https://github.com/TAIJI-zhanghd/homework/tree/master/springboot_redis_mongodb_homework)
 
# 2019/04/08-2019/04/12  spring security 安全框架
 > day01 [springboot_security_login_demo](https://github.com/TAIJI-zhanghd/homework/tree/master/springboot_security_login_demo)
 
	 - 功能：登陆、注册、过滤器访问端口权限控制、登录权限控制 	
 > day02 [springboot_security_hello](https://github.com/TAIJI-zhanghd/homework/tree/master/springboot_security_hello)
 
 	- 功能：登陆 注销 权限控制
 
 > day03 [springboot_security_jdbc_demo](https://github.com/TAIJI-zhanghd/homework/tree/master/springboot_security_jdbc_demo)
 
	- 功能：实现AuthenticationProvider接口的方法，实现自定义配置
	 	
		新增自定义过滤器，加入过滤器链中
		 
		基于access的SPEL表达式的鉴权
		 
		权限登陆配置
  > day04 [springboot_security_RBAC](https://github.com/TAIJI-zhanghd/homework/tree/master/springboot_security_RBAC)
 
 	- 功能：基本RBAC的实现
	
  > day05 [springboot_security_oauth2](https://github.com/TAIJI-zhanghd/homework/tree/master/springboot_security_oauth2)
 
 	- 功能：github授权认证
	
# 2019/04/01-2019/04/04  数据访问 ：一对多 多对一 

 > 作业 [jpa_many_to_many](https://github.com/TAIJI-zhanghd/homework/tree/master/jpa_many_to_many)
 
 	- 功能：顾客对应多个订单、多个订单对应一个顾客、删除顾客相应的订单也会消失、添加顾客和订单、删除顾客和订单
	
# 2019/03/27-2019/03/29  springMvc 

 > 作业 [springboot_login_system](https://github.com/TAIJI-zhanghd/homework/tree/master/springboot_login_system)

 	- 功能：登陆、注册、国际化、后台校验、拦截器拦截未登录的用户、拦截器拦截已注册的用户、thymeleaf、显示用户
	
# 2019/03/26  Springboot 日志、Actuator、Admin

	      project: springboot-helloword、springboot-sample-log4j2、springboot-sample-logback、springboot-actuator
	      	       springboot-admin-server、springboot-admin-client1、springboot-admin-client2
 >内容：
 
   -    SLF4J：定义了统一的日志框架接口，不提供具体的日志实现，真正的日志实现是在运行时决定的
	
   -    常见的日志框架：
   		- 1. Commons Logging 
		- 2. Java Util Logging 
		- 3. Log4J 
		- 4. Log4J2 
		- 5. logback：效率更高，适应于多环境
	    
   -    日志格式：
   	 	- 1. 时间日期：精确到秒 
		- 2. 日志级别：TRACE<DEBUG<INFO<WARN<ERROR 
		- 3. 进程ID 
		- 4. 分隔符（---）：标识日志的开始 -5.线程名：用方括号括起来的 
		- 5. Logger名：通常使用源码的类名 
		- 6. 日志内容

   -    日志输出：
   		- 1. 输出到控制台 ：logging.path=
		- 2. 输出到指定文件 : logging.file=

   -    日志默认输出为INFO，手动配置为logging.level.*=

   -    Springboot 应用默认将logback作为日志框架

   -    自定义日志配置：
   		- 1. 在src/main/resources下放置自定义配置文件 
		- 2. springboot 官方推荐以有 -spring的文件名作为你的日志配置 例：logback-spring.xml、Log4j-spring.properties
  
  -    多环境日志输出：据特定的环境（生产环境、测试环境）来定义不同的日志输出
  
  -    Springboot 单元测试
  
  -    Springboot Actuator:提供了对单个springboot的监控 
  		- 1. 熟悉常用的Endpoints 
		- 2. 打开关闭端点 
		- 3. 管理端点的安全保护 
		- 4. 在线更改日志级别
  		
  -    Springboot Admin 
  		- 1. server 
		- 2. client

# 2019/03/25  Springboot 搭建、profiles配置文件

	      project: springboot-helloworld,springboot-sample-profile
 >内容：
 
   -    Springboot 项目构建:  
   		- 1. web方式  
		- 2. ide方式
		
   -    运行Springboot三种方式： 
   		- 1. ide运行   
		- 2. jar命令 java -jar xxx.jar  
		- 3. maven插件 mvn spring-boot:run

   -    启动类定制： 
   		- 1. CommandLineRunner  
		- 2. ApplicationRunner  
		- 3. ApplicationListener

   -    热部署：spring-boot-devtools

   -    Springboot 配置文件: 配置文件外部的优先级大于内部的优先级

   -    lombok插件：省略setget方法，提高编程效率

   -    profiles：可以实现多场景下的配置切换，方便开发中进行测试和部署生产环境

# 2019/03/22  SpringIoc、DI

	      project: day03, day03_2      
 >内容：
 
   -    SpringIoc(控制反转): 程序不负责对象的创建与维护，而是由SpringIoc来负责对象的生命周期和对象之间的关系
		
   -    DI(依赖注入)：通过依赖注入实现了控制反转

   -    工厂模式、容器、实例化

   -    DI注入方式：
   		- 1. get set方法注入 
		- 2. 构造器注入

   -    Bean的作用域：Singleton（默认）、Prototype、request、session等

   -    Bean的生命周期：
   		- 1. 配置xml  init-method,destroy-method
		- 2. 实现接口  InitializingBean、DesposableBean
		- 3. 注解 @PostConstruct @PreDestroy

   -    容器的三种配置方式：
   		- 1. xml配置  
		- 2. 注解  
		- 3. java方式
