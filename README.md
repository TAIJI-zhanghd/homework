
# 2019/3/26  Springboot 日志

	      project: springboot-helloword、springboot-sample-log4j2、springboot-sample-logback、springboot-actuator
	      	       springboot-admin-server、springboot-admin-client1、springboot-admin-client2
 >内容：
 
   -    SLF4J：定义了统一的日志框架接口，不提供具体的日志实现，真正的日志实现是在运行时决定的
	
   -    常见的日志框架：
   	    	- 1.Commons Logging
	    	- 2.Java Util Logging
	    	- 3.Log4J
	    	- 4.Log4J2
	    	- 5.logback：效率更高，适应于多环境
	    
   -    日志格式：
   	 	-1.时间日期：精确到秒 
		-2.日志级别：TRACE<DEBUG<INFO<WARN<ERROR 
		-3.进程ID 
		-4.分隔符（---）：标识日志的开始 -5.线程名：用方括号括起来的 
		-6.Logger名：通常使用源码的类名 
		-7日志内容

   -    日志输出：
   		-1.输出到控制台 ：logging.path=
		-2.输出到指定文件 : logging.file=

   -    日志默认输出为INFO，手动配置为logging.level.*=

   -    Springboot 应用默认将logback作为日志框架

   -    自定义日志配置：
   		-1.在src/main/resources下放置自定义配置文件 
		-2.springboot 官方推荐以有 -spring的文件名作为你的日志配置 例：logback-spring.xml、Log4j-spring.properties
  
  -    多环境日志输出：据特定的环境（生产环境、测试环境）来定义不同的日志输出
  
  -    Springboot 单元测试

# 2019/3/25  Springboot 搭建、profiles配置文件

	      project: springboot-helloworld,springboot-sample-profile
 >内容：
 
   -    Springboot 项目构建:  
   		-1.web方式  
		-2.ide方式
		
   -    运行Springboot三种方式： 
   		-1.ide运行   
		-2.jar命令 java -jar xxx.jar  
		-3.maven插件 mvn spring-boot:run

   -    启动类定制： 
   		-1.CommandLineRunner  
		-2.ApplicationRunner  
		-3.ApplicationListener

   -    热部署：spring-boot-devtools

   -    Springboot 配置文件：  配置文件外部的优先级大于内部的优先级

   -    lombok插件：省略setget方法，提高编程效率

   -    profiles：可以实现多场景下的配置切换，方便开发中进行测试和部署生产环境

# 2019/3/22  SpringIoc、DI

	      project: day03, day03_2      
 >内容：
 
   -    springioc(控制反转):程序不负责对象的创建与维护，而是由SpringIoc来负责对象的生命周期和对象之间的关系
		
   -    DI(依赖注入)：通过依赖注入实现了控制反转

   -    工厂模式、容器、实例化

   -    DI注入方式：
   		-1.get set方法注入 
		-2.构造器注入

   -    Bean的作用域：默认（Singleton）

   -    Bean的生命周期：
   		-1.配置xml  
		-2.实现接口  
		-3.注解

   -    容器的三种配置方式：
   		-1.xml配置  
		-2.注解  
		-3.java方式
