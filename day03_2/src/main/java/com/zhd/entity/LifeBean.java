package com.zhd.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifeBean implements InitializingBean,DisposableBean{



	public void afterPropertiesSet() throws Exception {
		System.out.println("init lifebean");
		
	}
	public void destroy() throws Exception {
		System.out.println("destory lifebean");
		
	}
	
	
}
