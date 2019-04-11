package com.zhd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhd.service.BankService;

@RestController
public class MainController {

	@Autowired
	private BankService bankService;
	
	@GetMapping("/")
	public String Main1() {
		return "success";
	}
	@GetMapping("/bank")
	public String bank() {
		return "hello"+bankService.aaaaaaaa();
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	// 9.2 获取当前用户的登陆信息
	@GetMapping("/user")
	
	public String getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			return username;
		} else {
			String username = principal.toString();
			return username;
		}
	}
}
