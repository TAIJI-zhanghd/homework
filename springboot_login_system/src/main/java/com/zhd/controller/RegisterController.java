package com.zhd.controller;
/**
 * 注册新用户
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhd.bean.User;
import com.zhd.util.Utils;

@Controller
@RequestMapping("/mng")
public class RegisterController {

	@RequestMapping("/register")
	public String register(@ModelAttribute User user) {
		return "mng/register";
	}
	@RequestMapping("/registerUser")
	public String registerUser(@Validated User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "mng/register";
		}else {
			Utils.uList.add(user);
			model.addAttribute("name", user.getName());
			return "mng/success";
		}
	}
}
