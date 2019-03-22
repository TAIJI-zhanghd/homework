package com.zhd.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnoBean {

	@PostConstruct
	public void start() {
		System.out.println("init");
	}
	@PreDestroy
	public void  stop() {
		System.out.println("destroy");
	}
}
