package com.zhd.entity;

import org.springframework.stereotype.Component;

//@Component
public class XmlBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void start(){
		System.out.println("初始化");
	}
	public void stop() {
		System.out.println("销毁");
	}

	@Override
	public String toString() {
		return "LifeBean [name=" + name + "]";
	}
	
	
}
