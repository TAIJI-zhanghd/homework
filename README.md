# day04 2019/3/25

# 上午 运行一个简单的springboot项目

#       一些启动类的注解

#		启动类定制

# 下午  热部署

#		springboot 配置文件加载顺序优先级

#		配置开发、测试、生产环境的profile


# 2019/3/23  Springboot

	project: day03, day03_2
 >内容：
 
   -    Springboot 项目构建:  1.web方式  2.ide方式
		
   -    运行Springboot三种方式： 1.ide运行   2.jar命令 java -jar xxx.jar  3.maven插件 mvn spring-boot:run

   -    启动类定制： 1.CommandLineRunner  2.ApplicationRunner  3.ApplicationListener

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

   -    DI注入方式：get set方法注入 、构造器注入

   -    Bean的作用域：默认（Singleton）

   -    Bean的生命周期：1.配置xml  2.实现接口  3.注解

   -    容器的三种配置方式：1.xml配置  2.注解  3.java方式
