package com.zhd.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.zhd.service.MessageService;

@Component
@Profile({"goodbye"})
public class GoodbyeService implements MessageService{

	@Value("${name:World}")
	private String name;

	@Override
	public String getMessage() {
		return "Goodbye " + this.name;
	}
}
