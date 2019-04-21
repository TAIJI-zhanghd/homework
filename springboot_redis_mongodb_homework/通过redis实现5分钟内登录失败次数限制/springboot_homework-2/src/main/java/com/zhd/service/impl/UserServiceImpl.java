package com.zhd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhd.domain.User;
import com.zhd.domain.UserRepository;
import com.zhd.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepostory;
	
	@Override
	public User getUser(String username, String password) {
		return userRepostory.findByUsernameAndPassword(username, password);
	}

}
