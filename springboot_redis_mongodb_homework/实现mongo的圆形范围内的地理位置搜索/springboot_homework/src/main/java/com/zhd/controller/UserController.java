package com.zhd.controller;


import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.model.geojson.Position;
import com.zhd.model.User;
import com.zhd.service.UserService;

/**
 * 入口
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/withinPolygon")
	public List<Document> withinPolygon(){
		DBObject field=new BasicDBObject();
		int limit = 1;//
		
		List<Document> list=userService.withinCenter("location", "loc"
				,field, limit);
		for(Document obj : list)
			System.out.println(obj);
		return list;
	}

}
