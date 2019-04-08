package com.zhd.controller;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 注册新用户
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhd.bean.User;
import com.zhd.interceptor.RegisterInterceptor;
import com.zhd.util.Utils;

@Controller
@RequestMapping("/mng")
public class RegisterController {
	
	private static Logger logger = LoggerFactory.getLogger(RegisterInterceptor.class);

	@GetMapping("/register")
	public String register(@ModelAttribute User user) {
		logger.info("进入注册界面");
		return "mng/register";
	}
	@PostMapping("/registerUser")
	public String registerUser(@Validated User user,BindingResult result,Model model,HttpSession session) {
		if(result.hasErrors()) {
			return "mng/register";
		}else {
			Utils.uList.add(user);
			session.setAttribute("successName", user.getName());
			logger.info("注册成功");
			return "mng/success";
		}
	}
	/**
	 * 用户名重复的跳转页面
	 * @return zhd
	 */
	@GetMapping("/checkName")
	public String checkName() {
		logger.info("用户名重复");
		return "mng/checkName";
	}
}
