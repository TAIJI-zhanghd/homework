package com.zhd.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifeBean implements InitializingBean,DisposableBean{

	private Logger logger = LoggerFactory.getLogger(getClass());

	public void afterPropertiesSet() throws Exception {
//		System.out.println("init lifebean");
		logger.info("init lifebean");
		
	}
	public void destroy() throws Exception {
//		System.out.println("destory lifebean");
		logger.info("destory lifebean");
	}
	
	
}
