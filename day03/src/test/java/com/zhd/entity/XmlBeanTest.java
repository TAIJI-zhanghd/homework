package com.zhd.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanTest {

	private ApplicationContext context;
	
	public XmlBeanTest() {
		context = new ClassPathXmlApplicationContext("classpath:META-INF/bean.xml");
	}
	@Test
	public void testXmlBean() {
		((AbstractApplicationContext)context).registerShutdownHook();
	}
	@Test
	public void testLife() {
		context.getBean("lifeBean",LifeBean.class);
	}
}
