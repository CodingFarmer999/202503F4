package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.UserDao;
import com.course.entity.User;
import com.course.vo.UserVo;

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
		User user = findById(id);
		
		if (user != null) {
			userDao.delUser(user);
		}
		
	}
	
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	/**
	 * 更新使用者資料
	 * 
	 * @param userVo
	 */
	public void upateUser(UserVo userVo) {
		User user = findByUsername(userVo.getUsername());

		// "", " "
		if (userVo.getPassword() != null && !userVo.getPassword().isBlank()) {
			user.setPassword(userVo.getPassword());
		}

		if (userVo.getEmail() != null && !userVo.getEmail().isBlank()) {
			user.setEmail(userVo.getEmail());
		}

		if (userVo.getBirthDay() != null && !userVo.getBirthDay().isBlank()) {
			user.setBirthDay(parseDate(userVo.getBirthDay()));
		}

		userDao.updateUser(user);
	}
	
	private Date parseDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(dateStr);
			System.out.println("Parsed Date: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
