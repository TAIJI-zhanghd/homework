package com.zhd.interceptor;
/**
 * 拦截未登录的用户访问界面的拦截器
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private static Logger logger = LoggerFactory.getLogger(RegisterInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("到达LoginInterceptor拦截器preHandle");
		if(null != request.getSession().getAttribute("name")) {
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/mng/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("到达LoginInterceptor拦截器postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("到达LoginInterceptor拦截器afterCompletion");
	}

}
