package com.zhd.controller;
/**
 * 用户管理（控制层） 目前只有展示
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhd.bean.User;
import com.zhd.interceptor.RegisterInterceptor;
import com.zhd.util.Utils;

@Controller
@RequestMapping("/mng/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(RegisterInterceptor.class);
	
	@RequestMapping("/show")
	public String show(Model model) {
		List<User> uList = Utils.uList;
		int size = uList.size();
		if(uList.size() != 0) {
			logger.info("uList集合展示"+uList.toString());
			model.addAttribute("number", size );
			model.addAttribute("uList", uList);
		}
		return "mng/user/show";
	}
}
