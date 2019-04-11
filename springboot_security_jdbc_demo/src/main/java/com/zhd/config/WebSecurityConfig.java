package com.zhd.config;
/**
 * 接口配置类
 */
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.zhd.config.MyAuthenticationSuccessHandler;
//import com.zhd.config.MyLogoutSuccessHandler;

@Configuration
@EnableWebSecurity(debug = true)  //查看过滤器链  （打印到控制台）
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//之所以能引进来    引入jdbc  jpa的包  是因为有自动配置
	@Autowired
	private DataSource dataSource;

	@Autowired
	private CustomFilter customFilter;
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	/**
	 * 不建议这样做   应该从数据库获取数据作为用户
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource);
		
		//自定义实现  自己的方法
		auth
			.authenticationProvider(customAuthenticationProvider);
		
//				.withDefaultSchema()
//				.withUser("1").password("1").roles("USER")
//				.and().withUser("2").password("2").roles("ADMIN")
//				.and().withUser("3").password("3").authorities("DBA")
//				.and().withUser("4").password("4").roles("ADMIN","DBA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/h2-console/**")
				.permitAll()
				
				//sqel 表达式语言   为true就是可以访问   为false就是不可访问
//				.access("0>1")   //不管登不登陆   都不能访问   
//				.access("true")	//全部都可以访问
				
//				1.基于access的SPEL表达式的鉴权   （要把.anyRequest().authenticated()注释）
				.anyRequest().access("@customAccessControlService.canAccess(request,authentication)")
				;
				//除了/h2-console  不用登陆   其他全部都要登陆
//				.anyRequest().authenticated();;
		
		http
			.formLogin();
		
		http.csrf().ignoringAntMatchers("/h2-console/**");
		http.headers().frameOptions().sameOrigin();
		
		//增加自定义filter
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
//		http.addFilterAfter(filter, afterFilter); 在。。。之后
//		http.addFilterAt(filter, atFilter); 替换
	}
	//web主要配置一些静态资源
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		/**
		 * 不走以下的静态资源
		 */
		web.ignoring().antMatchers("/gavicon.ico");
	}
}
