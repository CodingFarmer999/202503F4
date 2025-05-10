package com.course.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.excpetion.ActionException;
import com.course.model.entity.UserEntity;
import com.course.model.session.CartSession;
import com.course.model.session.UserSession;
import com.course.model.vo.UserVo;
import com.course.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserSession userSession;
	
	@Autowired
	private CartSession cartSession;
	
	/**
	 * 使用者登入作業
	 * @param email
	 * @param password
	 * @return
	 * @throws ActionException 
	 */
	public UserVo userLogin(String email, String password) throws ActionException {
		
		UserEntity user = userRepo.findByEmailAndPassword(email, password);
		
		if (user != null) {
			// 已登入，將使用者資訊記錄在Session當中
			userSession.setId(user.getId());
			userSession.setEmail(user.getEmail());
			userSession.setName(user.getName());
			userSession.setMobile(user.getMobile());
			
			UserVo vo = new UserVo();
			vo.setEmail(user.getEmail());
			vo.setName(user.getName());
			vo.setMobile(user.getMobile());
			
			return vo;
			
		} else {
			// 返回登入頁，並提示用戶不存在
			throw new ActionException("用戶不存在", "USER_NOT_FOUND");
		}
	}
	
	/**
	 * 登出作業
	 * 把該清除了東西清空
	 */
	public void logout() {
		userSession = new UserSession();
		cartSession.setProductVoList(new ArrayList<>());
	}
	
	/**
	 * 檢查是否是登入狀態
	 * @param email
	 * @return
	 */
	public boolean checkLogin(String email) {
		if (userSession != null) {
			return userSession.getEmail().equals(email);
		}
		return false;
	}

}
