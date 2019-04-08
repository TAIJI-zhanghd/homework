package com.zhd;
/**
 * 过滤器配置类
 */
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.zhd.filter.EncodingFilter;
import com.zhd.filter.LogoutFilter;
import com.zhd.filter.Myfilter;
import com.zhd.filter.UserFilter;

@Configuration
public class MyFilterConfig {

	private static Logger logger = LoggerFactory.getLogger(MyFilterConfig.class);

	@Bean
	public FilterRegistrationBean EncodingFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		EncodingFilter filter = new EncodingFilter();
		registrationBean.setFilter(filter); // 设置过滤器拦截请求
		//当前过滤器要通过拦截哪些端口
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		registrationBean.setOrder(1);
		return registrationBean;
	}
	@Bean
	public FilterRegistrationBean LogoutFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		LogoutFilter logoutFilter = new LogoutFilter();
		registrationBean.setFilter(logoutFilter); // 设置过滤器拦截请求
		//当前过滤器要通过拦截哪些端口
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		registrationBean.setOrder(2);
		return registrationBean;
	}
	@Bean
	@Order(3)
	public FilterRegistrationBean Myfilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		Myfilter filter = new Myfilter();
		registrationBean.setFilter(filter); // 设置过滤器拦截请求
		//当前过滤器要通过拦截哪些端口
		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		registrationBean.setOrder(3);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean UserFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		
		
		//用户权限拦截 
		UserFilter ufilter =  new UserFilter();
		registrationBean.setFilter(ufilter);
		List<String> urls = new ArrayList<>();
		urls.add("/a");
		urls.add("/b");
		registrationBean.setUrlPatterns(urls);
		registrationBean.setOrder(4);
		return registrationBean;
	}
	
}
