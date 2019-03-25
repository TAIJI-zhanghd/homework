package com.zhd.config;
/**
 * 可以引入xml配置文件，和使用java导入bean
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations= {"classpath:application-context.xml"})
public class ConfigClass {

}
