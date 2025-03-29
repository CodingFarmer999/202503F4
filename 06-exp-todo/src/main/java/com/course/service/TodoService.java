package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.TodoDao;

@Service
public class TodoService {
	
	@Autowired
	private TodoDao todoDao;
}
