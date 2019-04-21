package com.zhd.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsernameAndPassword(String username,String password);
}
