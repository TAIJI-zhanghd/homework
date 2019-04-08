package com.zhd.filter;
/**
 * 退出登陆的filter
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
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(LogoutFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("LogoutFilter destroy");
	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		logger.info("LogoutFilter doFilter");
		HttpServletRequest request = (HttpServletRequest)requ;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);
	        String path = request.getServletPath();
	        if ("/logout".equals(path)) {
	            // 如果当前调用的是登出接口
	            if (session == null || session.getAttribute("username") == null) {
	                //用户session不存在，处于未登录状态，直接返回
	            	response.getWriter().write("用户并没登陆");
	                return;
	            }
	            // 如果是登出端口，则直接删除session进行登出操作，不用进入到controller 层
	            session.removeAttribute("username");
	            response.getWriter().write("退出登录成功!");
	            return;
	        }

	        chain.doFilter(requ, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("LogoutFilter init");
	}

}
