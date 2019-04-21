package com.zhd.serviceimpl;


import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.zhd.dao.UserDao;
import com.zhd.model.User;
import com.zhd.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<Document> withinCenter(String collection, String locationField, DBObject fields, int limit) {
		// TODO Auto-generated method stub
		return userDao.withinCenter(collection, locationField, fields, limit);
	}

}
