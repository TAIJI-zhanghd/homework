package com.zhd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${my.name}")
	private String name;
	@Value("${my.id}")
	private String id;
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello world"+name +id;
	}
}
