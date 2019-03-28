package com.zhd.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.zhd.service.MessageService;

@Component
@Profile({"hello","default","dev"})
public class HelloService implements MessageService{

	@Value("${name:World}")
	private String name;

	@Override
	public String getMessage() {
		return "Hello " + this.name;
	}
}
