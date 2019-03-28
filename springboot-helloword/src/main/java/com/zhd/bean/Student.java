package com.zhd.bean;
/**
 * 使用bean一次性注入
 */
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;


@Component
@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "student")

@Data
@ToString
public class Student {

	private String name;
	private Integer age;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Integer getAge() {
//		return age;
//	}
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", age=" + age + "]";
//	}
	
	
}
