package com.zhd.interceptor;
/**
 * 刷新显示用户名重复的拦截器
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class RegisterInterceptor implements HandlerInterceptor{

	private static Logger logger = LoggerFactory.getLogger(RegisterInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("RegisterInterceptor  preHandle ");
		if(null == request.getSession().getAttribute("successName")) {
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/mng/checkName");
			request.getSession().removeAttribute("successName");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("RegisterInterceptor拦截器 postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("RegisterInterceptor拦截器 afterCompletion");
	}

}
