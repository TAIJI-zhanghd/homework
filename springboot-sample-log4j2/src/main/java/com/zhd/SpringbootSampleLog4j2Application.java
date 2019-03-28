package com.zhd;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSampleLog4j2Application {

	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@PostConstruct
	public void getlogger() {
		logger.debug("debug-----");
		logger.info("info------");
		logger.warn("warn------");
	}
	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootSampleLog4j2Application.class, args);
	}

}
