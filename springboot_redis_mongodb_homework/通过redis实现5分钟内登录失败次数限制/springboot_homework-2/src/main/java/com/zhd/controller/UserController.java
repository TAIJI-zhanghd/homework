package com.zhd.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhd.domain.User;
import com.zhd.service.UserService;

@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private String LOGIN_COUNT_;
	@Autowired
	private UserService userService;
	
	@Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;
 
	@RequestMapping("/login")
	@ResponseBody
	public String login(String username,String password) {
		
		// 如果用户输入账号密码有效登录超过限制次数,24小时禁止登录
		// 3次失败，不允许登陆 
		
		String count = (String) redisTemplate.opsForValue().get(LOGIN_COUNT_+username);
//		Long count = Long.parseLong(null);
		//    	先判断登陆失败的次数
		if(count != null){
    		// 如果大于3次  直接返回提示信息  
			if (count == "3") {
				//返回前端信息"您今天登录失败的次数已经超过限制，请明天再试。"
				logger.error("账号为【" + username + "】的用户单日登录次数超过上限");
				return "账号为【" + username + "】的用户单日登录次数超过上限";
			}
		} 
//		// ... 去数据库根据username查询user对象
		User user = userService.getUser(username, password);
    	//如果 查询结果为空   就增加失败次数
		if(user == null){ 
			// 往redis中增加登录失败的次数 
			redisTemplate.opsForValue().increment(LOGIN_COUNT_+username,1);
    		//前台显示  
			
			return "账号为【" + username + "】的用户登录失败,";
			
		}else{
			// 登录成功,清除redis失败记录
			redisTemplate.delete(LOGIN_COUNT_+username);
			return "登录界面";
		}
	}

	

}
