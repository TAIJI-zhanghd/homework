package com.zhd.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {

	private String name;
	@Value("1")
	private Integer age;
	
	private boolean gender;
	
	
	
	public Dog() {
		super();
	}
	public Dog(String name, Integer age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void say() {
		System.out.println(getName()+"汪汪汪");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
}
