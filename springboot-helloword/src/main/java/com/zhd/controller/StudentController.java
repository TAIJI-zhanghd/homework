package com.zhd.controller;
/**
 * 一次性注入
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhd.bean.Student;

@RestController
public class StudentController {

	@Autowired
	private Student student;
	
	@RequestMapping("/stu")
	public String student() {
		return student.toString() + student.getName();
	}
}
