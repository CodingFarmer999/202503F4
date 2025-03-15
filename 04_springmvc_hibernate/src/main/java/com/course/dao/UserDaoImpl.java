package com.course.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) {
		// 呼叫DB
		return null;
	}

	@Override
	public void addUser(String username, String password) {
		System.out.println("Add User");
		
	}

}
