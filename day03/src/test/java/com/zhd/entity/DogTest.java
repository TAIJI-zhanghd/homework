package com.zhd.entity;

import javax.swing.text.AbstractDocument.LeafElement;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogTest {
	
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void beforeClass() {
		context = new ClassPathXmlApplicationContext("classpath:META-INF/application-context.xml");
	}

	@Test
	public void testDog() {
		Dog dog = context.getBean(Dog.class,"dog");
		System.out.println(dog);
	}
	
	@Test
	public void testAnimal() {
		Animal animal = context.getBean(Animal.class);
		System.out.println(animal);
	}
	
}
