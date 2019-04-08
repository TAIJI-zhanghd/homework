package com.zhd.filter;
/**
 * 配置全局的字符集filter
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncodingFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(EncodingFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("EncodingFilter destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("EncodingFilter doFilter");
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("EncodingFilter init");
	}

}
