package com.zhd.configClass;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhd.entity.AnnoBean;
import com.zhd.entity.Dog;

@Configuration
//@ComponentScan(basePackages="com.zhd")
public class SimpleConfig {

	@Bean("d")
	public Dog dog() {
		Dog dog = new Dog();
		dog.setName("asdasd");
		return dog;
	}
	
	@Bean
	public AnnoBean annoBean() {
		return new AnnoBean();
	}
	
	@Bean
	DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("app");
		ds.setPassword("app");
		ds.setUrl("jdbc:mysql://localhost:3306/app?useUnicode=true&characterEncoding=utf-8");
		return ds;
	}
}
