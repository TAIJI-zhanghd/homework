package com.zhd.entity;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("c")
public class Cat {

	private String name;

	public Cat(String name) {
		super();
		this.name = name;
	}

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
	
	
}
