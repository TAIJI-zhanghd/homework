package com.zhd.service;


import java.util.List;

import org.bson.Document;
import org.springframework.data.domain.Pageable;

import com.mongodb.DBObject;
import com.zhd.model.User;

public interface UserService {

	List<Document> withinCenter(String collection, String locationField,
			  DBObject fields, int limit);
}
