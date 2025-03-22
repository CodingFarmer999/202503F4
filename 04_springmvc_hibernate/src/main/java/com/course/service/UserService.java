package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.UserDao;
import com.course.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean login(String username, String password) {
		// 判斷登入成功或失敗
		
		User user = userDao.findByUsernameAndPassword(username, password);
		if (user != null) {
			// 登入成功
			return true;
		} else {
			// Fail
			return false;
		}
	}
	
	public void addUser(String username, String password) {
		// 如果有邏輯的話，寫在這
		// 
		
		// Entity
		User user = new User(username, password);
		userDao.addUser(user);
	}
	
	public List<User> findAllUser() {
		return userDao.findAll();
	}
	
	public User findById(Integer id) {
		return userDao.findById(id);
	}
	
	/**
	 * 透過 ID 刪除使用者
	 * 
	 * @param id
	 */
	public void deleteByUserId(Integer id) {

	}
}
