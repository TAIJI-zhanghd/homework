package com.zhd.controller;
/**
 * xml方式注入bean
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhd.bean.User;

@RestController
public class XmlUserController {

	@Autowired
	private User user;
	
	@RequestMapping("/user")
	public String user() {
		return user.getName();
	}
}
