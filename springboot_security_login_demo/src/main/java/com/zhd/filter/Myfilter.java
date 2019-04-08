package com.zhd.filter;
/**
 * 登录操作的过滤器
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

public class Myfilter implements Filter{

	private static Logger logger = LoggerFactory.getLogger(Myfilter.class);
	
	@Override
	public void destroy() {
		logger.info("Myfilter destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Myfilter doFilter");
		HttpServletRequest requ = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if(null != requ.getSession().getAttribute("username") ) {
			chain.doFilter(request, response);
		}else if(requ.getRequestURI().contains("/login")
				|| requ.getRequestURI().contains("/register")) {
			chain.doFilter(request, response);
		}else {
//			resp.setCharacterEncoding("GBK");
			resp.getWriter().write("但前无用户登录,请登录后再访问");
		}
		logger.info("MyFilter 过滤器执行完毕");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("Myfilter init");
	}

}
