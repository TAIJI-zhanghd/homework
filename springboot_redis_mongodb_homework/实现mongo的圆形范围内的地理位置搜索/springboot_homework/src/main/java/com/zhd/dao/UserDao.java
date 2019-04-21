package com.zhd.dao;

import java.util.List;

import org.bson.Document;
import org.springframework.data.domain.Pageable;

import com.mongodb.DBObject;
import com.zhd.model.User;

/**
 *
 */
public interface UserDao {


	List<Document> withinCenter(String collection, String locationField, 
			DBObject fields, int limit);


	}
