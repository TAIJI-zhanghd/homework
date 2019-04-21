package com.zhd.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhd.domain.User;
import com.zhd.domain.UserRepository;

@Service
public class DataInit {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		User user= new User();
		user.setUsername("admin");
		user.setPassword("1");
		userRepository.save(user);
	}
}
