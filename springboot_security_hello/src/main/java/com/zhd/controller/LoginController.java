package com.zhd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/prelogin")
	public String login() {
		return "loginPage";
	}
	
	@GetMapping("/logoutSuccess")
	public String logoutSuccess() {
		return "logoutSuccess";
	}
}
