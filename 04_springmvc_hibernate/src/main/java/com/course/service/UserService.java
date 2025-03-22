package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.UserDao;
import com.course.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void addUser(String username, String password) {
		// 如果有邏輯的話，寫在這
		// 
		
		// Entity
		User user = new User(username, password);
		userDao.addUser(user);
	}
}
