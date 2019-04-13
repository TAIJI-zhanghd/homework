package com.zhd.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zhd.domain.UserInfo;

/**
 * Created by iandtop on 2018/12/11.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
