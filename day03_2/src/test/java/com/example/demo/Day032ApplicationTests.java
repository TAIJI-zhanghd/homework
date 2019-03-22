package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhd.entity.Animal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Day032ApplicationTests {

	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	
	@Test
	public void testBean() {
		context.scan("com.zhd");
		context.refresh();
		context.registerShutdownHook();
		
		Animal bean = context.getBean(Animal.class);
		System.out.println(bean);
	}
}
