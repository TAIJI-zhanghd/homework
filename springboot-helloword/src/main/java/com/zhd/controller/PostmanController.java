package com.zhd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostmanController {

	Logger logger = LoggerFactory.getLogger(PostmanController.class);
	
	@RequestMapping("/postman")
	public String postman() {
		logger.trace("-----trace级别");
		logger.debug("-----debug日志级别");
		logger.info("------info级别");
		logger.warn("------warn日志级别");
		logger.error("-------error 日志级别");
		return "success";
	}
}
