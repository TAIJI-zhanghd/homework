package com.zhd;
/**
 * 自定义的WebMvcConfigurerAdapter
 */
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.zhd.interceptor.LoginInterceptor;
import com.zhd.interceptor.RegisterInterceptor;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean(name = "messageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
	}

	/**
	 * 配置
	 */
	@Bean("localeChangeInterceptor")
	public LocaleChangeInterceptor LocaleChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	@Bean("localeResolver")
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
		return slr;
	}


	/**
	 * 将国际化拦截器加载到拦截其中
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(LocaleChangeInterceptor());
		//登陆拦截
		registry.addInterceptor(new LoginInterceptor())
		.excludePathPatterns("/mng/login","/mng/loginUser","/mng/register","/mng/registerUser","/mng/checkName");
		//拦截注册用户是否重复
		registry.addInterceptor(new RegisterInterceptor()).addPathPatterns("/mng/registerUser");
	}

	
	
}
