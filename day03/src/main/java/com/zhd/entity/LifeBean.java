package com.zhd.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifeBean implements InitializingBean,DisposableBean{


	public void destroy() throws Exception {
		System.out.println("init lifebean");
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("destory lifebean");
		
	}
	
	
}
