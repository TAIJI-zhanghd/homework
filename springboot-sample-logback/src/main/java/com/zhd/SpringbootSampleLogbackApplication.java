package com.zhd;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSampleLogbackApplication {


	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@PostConstruct
	public void getlogger() {
		logger.trace("trace-----");
		logger.debug("debug-----");
		logger.info("info------");
		logger.warn("warn------");
		logger.error("error-----");
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootSampleLogbackApplication.class, args);
	}

}
