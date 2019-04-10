package com.zhd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.zhd.config.MyAuthenticationSuccessHandler;
import com.zhd.config.MyLogoutSuccessHandler;

@EnableWebSecurity(debug = true)  //查看过滤器链
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("1").password("1").roles("USER").build());
//		manager.createUser(User.withUsername("2").password("2").roles("ADMIN").build());
//		manager.createUser(User.withUsername("3").password("3").roles("DBA").build());
//		manager.createUser(User.withUsername("4").password("4").roles("DBA","ADMIN").build());
//		return manager;
//	}
	/**
	 * 认证管理相关
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
		auth.inMemoryAuthentication().withUser("1").password("1").roles("USER")
				.and().withUser("2").password("2").roles("ADMIN")
				.and().withUser("3").password("3").roles("DBA")
				.and().withUser("4").password("4").roles("ADMIN","DBA");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/prelogin","/login","/resources/**", "/signup", "/about").permitAll() 
				.antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
                .regexMatchers("^/a$").hasRole("ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN")                                    
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") 
				.anyRequest().authenticated();
		
		http
			.formLogin()
				.loginPage("/prelogin")
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				//匿名内部类  实际开发中为避免new对象线程安全问题     
				//建议新创建一个类   并用@Bean 加载到容器中（也可以用Complent进行注入  但是不灵活）
				.successHandler(MyAuthenticationSuccessHandler())
//				.permitAll() 
				;
		http
			.logout()
				.logoutUrl("/logout")  //默认时/logout
				
//				.logoutSuccessUrl("/prelogin")
				.logoutSuccessHandler(MyLogoutSuccessHandler())
				.deleteCookies("ZSESSIONID")
//				.permitAll() 
				;
	}
	@Bean
	public MyAuthenticationSuccessHandler MyAuthenticationSuccessHandler() {
		return new MyAuthenticationSuccessHandler();
	}
	@Bean
	public MyLogoutSuccessHandler MyLogoutSuccessHandler() {
		return new MyLogoutSuccessHandler();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}
}
