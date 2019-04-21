package com.zhd.daoimpl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.zhd.dao.UserDao;
import com.zhd.model.User;

/**
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	/**
	 * 由springboot自动注入，默认配置会产生mongoTemplate这个bean
	 */
	@Autowired
	private MongoTemplate mongoTemplate;

	

	/**
	 * 实现mongo的圆形范围内的地理位置搜索
	 */
	@Override
	public List<Document> withinCenter(String collection, String locationField, 
			DBObject fields, int limit) {
	
		Bson bsonCenter = Filters.geoWithinCenter(locationField, 5, 5, 10); 
	
		MongoCursor<Document> mongoCursor = mongoTemplate.getCollection(collection).find(bsonCenter).limit(limit).iterator();
		List<Document> result = new ArrayList<Document>();
		while(mongoCursor.hasNext()){
			result.add(mongoCursor.next());
		}
		return result;
	}

}
