package com.zhd.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhd.domain.UserInfo;
import com.zhd.repository.UserInfoRepository;
import com.zhd.service.UserInfoService;

/**
 * Created by iandtop on 2018/12/11.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }
}
