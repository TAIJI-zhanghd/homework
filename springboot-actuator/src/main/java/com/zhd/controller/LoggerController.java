package com.zhd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoggerController {

	private final static Logger logger = LoggerFactory.getLogger(LoggerController.class);
	
	@RequestMapping("/logger")
	public String getLogger() {
		logger.trace("--trace 级别--");
		logger.debug("--debug 级别--");
		logger.info("--info 级别--");
		logger.warn("--warn 级别--");
		logger.error("--error 级别--");
		return "success";
	}
	
}
