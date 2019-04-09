package com.zhd.controller;
/**
 * 验证用户登录
 */
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhd.bean.User;
import com.zhd.interceptor.RegisterInterceptor;
import com.zhd.util.Utils;

@Controller
@RequestMapping("/mng")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(RegisterInterceptor.class);
	
	@GetMapping("/login")
	public String login(@ModelAttribute User user) {
		logger.info("进入登陆界面");
		return "mng/login";
	}
	@PostMapping("/loginUser")
	@ResponseBody
	public String loginUser(User user,HttpSession session) {
		for (User u : Utils.uList) {
			if(null != user.getName() && null != user.getPwd()) {
				if(u.getName().equals(user.getName()) && u.getPwd().equals(user.getPwd())) {
					session.setAttribute("name", user.getName());
					logger.info("登陆成功");
					return "1";
				}
			}
		}
		return "0";
	}
}
