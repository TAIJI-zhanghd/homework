package com.zhd.service;
import java.util.List;

//1.基于access的SPEL表达式的鉴权
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.zhd.domain.Permissions;
import com.zhd.domain.Users;

@Component
public class CustomAccessControlService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * @param request
	 * @param authentication
	 * @return  相当于  .access("true")	//全部都可以访问 
	 */
	public boolean canAccess(HttpServletRequest request,
			Authentication authentication) {
		//具体鉴权逻辑
		// 1.在未登陆的情况下要做一些判断或者是拦截
		
		/**
		 * 如果是未登录状态
		 */
		Object principal = authentication.getPrincipal();
		if("anonymousUser".equals(principal)) {
			return false;
		}
		//who  authentication 当前用户
		//what  request 请求地址
		//how  权限   通过查表获得
		String username = ((Users)authentication.getPrincipal()).getUsername();
		String path = request.getServletPath();
		
		String sql = "select p.authority,p.url\r\n" + 
				" from users u \r\n" + 
				" LEFT JOIN authorities a on u.username = a.username\r\n" + 
				" LEFT JOIN permissions p on a.authority = p.authority\r\n" + 
				" where u.username = '"+username+"'";
		List<Permissions> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Permissions.class));
		boolean hasPath = false;
		for (Permissions p : list) {
			if(p.getUrl().equals(path)) {
				hasPath = true;
			}		
		}
		return hasPath;
	}
}
