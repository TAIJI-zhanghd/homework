package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhd.configClass.SimpleConfig;
import com.zhd.entity.AnnoBean;
import com.zhd.entity.Dog;

public class JavaConfigTest {
	

	AnnotationConfigApplicationContext context;
	@Before
	public void testBefore() {
		context= new AnnotationConfigApplicationContext(SimpleConfig.class);
		context.registerShutdownHook();
		
		int count = context.getBeanDefinitionCount();
		System.out.println("容器中bean的数量"+count);
	}
	
	@Test 
	public void testDog(){
		Dog dog = (Dog)context.getBean("d");
		System.out.println(dog);
	}
	@Test
	public void testAnnoBean() {
		AnnoBean bean = context.getBean(AnnoBean.class);
		System.out.println(bean);
	}
}
