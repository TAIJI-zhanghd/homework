package com.zhd.entity;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Animal {

	private int id;
	@Autowired  //根据类型注入
//	@Resource 根据名字注入
	private Dog dog;
	@Autowired  //根据类型注入
	@Qualifier("c")
	private Cat cat;
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(int id, Dog dog, Cat cat) {
		super();
		this.id = id;
		this.dog = dog;
		this.cat = cat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", dog=" + dog + ", cat=" + cat + "]";
	}
	
	
}
