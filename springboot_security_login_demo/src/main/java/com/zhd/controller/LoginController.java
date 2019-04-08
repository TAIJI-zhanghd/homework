package com.zhd.controller;
/**
 * 登陆controller
 */
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhd.bean.User;
import com.zhd.utils.StaticList;

@RestController
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	List<User> list = StaticList.list;

	@GetMapping("/register")
	public String register(User user) {
		System.out.println(user);
		if(user.getName() != null && user.getPwd() != null) {
			list.add(user);
			logger.info(list.toString());
			return "register success";
		}
		return "register failure";
	}
	
	@GetMapping("/login")
	public String login(User user,HttpSession session) {
		
		if(!CollectionUtils.isEmpty(list) 
				&& user.getName() != null && user.getPwd() != null) {
			for (User u : list) {
				if(u.getName().equals(user.getName()) && u.getPwd().equals(user.getPwd())) {
					session.setAttribute("username", user.getName());
					logger.info(user.toString());
					return "login success";
				}
			}
		}
		return "login failure";
	}
	
	@GetMapping("/a")
	public String a() {
		return "aaaaaaaaaaaaaaaa";
	}
	@GetMapping("/b")
	public String b() {
		return "bbbbbbbbbbbbbbbb";
	}
}
