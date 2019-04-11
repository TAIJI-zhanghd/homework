package com.zhd.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class BankService {
	/**
	 * 设置能访问的用户角色
	 * @return
	 */
    @Secured("ROLE_USER")
    public String aaaaaaaa() {
        return "我是被保护的方法";
    }
}
