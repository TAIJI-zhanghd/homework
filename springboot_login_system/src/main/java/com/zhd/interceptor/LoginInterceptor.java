package com.zhd.interceptor;
/**
 * 拦截未登录的用户访问界面的拦截器
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("到达拦截器preHandle");
		if("/mng/login".equals(request.getServletPath())
				|| "/mng/loginUser".equals(request.getServletPath())
				|| "/mng/register".equals(request.getServletPath())
				|| "/mng/registerUser".equals(request.getServletPath())) {
			return true;
		}else if(null != request.getSession().getAttribute("name")) {
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/mng/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("到达拦截器postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("到达拦截器afterCompletion");
	}

}
