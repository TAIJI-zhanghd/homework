package com.zhd.filter;
/**
 * user权限登陆的过滤器
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserFilter implements Filter{

	private static Logger logger = LoggerFactory.getLogger(UserFilter.class);
	@Override
	public void destroy() {
		logger.info("UserFilter 过滤器销毁  destroy");
	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("UserFilter 过滤器进入到  doFilter方法");
		HttpServletRequest request = (HttpServletRequest)requ;
		HttpServletResponse response = (HttpServletResponse) resp;
		String username = (String)request.getSession().getAttribute("username");
		if(username.equals("user") && !request.getServletPath().equals("/a")) {
//			response.setCharacterEncoding("GBK");
			response.getWriter().write("user用户并不能访问 b端口");
			return;
		}
		chain.doFilter(requ, resp);
//		if(null != username 
//				&& username.equals("admin")) {
//			chain.doFilter(requ, resp);
//		}else{
//			response.setCharacterEncoding("GBK");
//			response.getWriter().write("user用户并不能访问 b端口");
//		}
		logger.info("UserFilter 过滤器执行完毕");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("UserFilter 过滤器 init初始化");
	}

}
