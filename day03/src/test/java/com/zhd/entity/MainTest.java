package com.zhd.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/application-context.xml");
		int count = context.getBeanDefinitionCount();
		System.out.println("beanµÄ¸öÊý"+count);
		
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.print(name+"----->");
			System.out.println(context.getBean(name));
		}
		context.getBean("dog" ,Dog.class).say();
		
		System.out.println(context.getBean("animal",Animal.class).getId());
		System.out.println(context.getBean("animal",Animal.class).getDog().getName());
		System.out.println(context.getBean("animal",Animal.class).getCat().getName());
		
	}
}
