package com.zhd.controller;
/**
 * 用户管理（控制层）
 */
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhd.bean.User;
import com.zhd.util.Utils;

@Controller
@RequestMapping("/mng/user")
public class UserController {
	
	
	@RequestMapping("/show")
	public String show(Model model) {
		List<User> uList = Utils.uList;
		int size = uList.size();
		if(uList.size() != 0) {
			model.addAttribute("number", size );
			model.addAttribute("uList", uList);
		}
		return "mng/user/show";
	}
}
