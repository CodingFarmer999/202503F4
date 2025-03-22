package com.course.dao;

import java.util.List;

import com.course.entity.User;

public interface UserDao {

	/**
	 * JAVA DOC
	 * 取得所有使用者
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 透過ID取得使用者
	 * @param id
	 * @return
	 */
	User findById(Integer id);
	
	/**
	 * 透過UserName取得使用者
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	public User findByUsernameAndPassword(String username, String password);
	
	/**
	 * 新增使用者
	 * @param username
	 * @param password
	 */
	public void addUser(User user);
	
	public void delUser(User user);
	
	public void updateUser(User user);
}
