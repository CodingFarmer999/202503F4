package com.course.dao;

import com.course.entity.User;

public interface UserDao {

	// 透過UserName取得使用者
	public User findByUsername(String username);
	
	/**
	 * 新增使用者
	 * @param username
	 * @param password
	 */
	public void addUser(String username, String password);
}
