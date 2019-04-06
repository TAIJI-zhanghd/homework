package com.zhd.controller;
/**
 * 验证用户登录
 */
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhd.bean.User;
import com.zhd.util.Utils;

@Controller
@RequestMapping("/mng")
public class LoginController {

	@RequestMapping("/login")
	public String login(@ModelAttribute User user) {
		return "mng/login";
	}
	@RequestMapping("/loginUser")
	@ResponseBody
	public String loginUser(User user,HttpSession session) {
		for (User u : Utils.uList) {
			if(null != user.getName() && null != user.getPwd()) {
				if(u.getName().equals(user.getName()) && u.getPwd().equals(user.getPwd())) {
					session.setAttribute("name", user.getName());
					return "1";
				}
			}
		}
		return "0";
	}
}
