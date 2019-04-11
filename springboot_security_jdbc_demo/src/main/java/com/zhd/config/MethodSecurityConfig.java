package com.zhd.config;
/**
 * 配置一个全局类  进行对方法级别的保护
 */
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig {
}
