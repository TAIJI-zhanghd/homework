package com.zhd.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping({"/hello"})
	public String hello(Principal p) {
		return "hello"+p.getName().toString();
	}
}
