package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(String username, String password) {
		// 如果有邏輯的話，寫在這
		userDao.addUser(username, password);
	}
}
