package com.course.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.excpetion.ActionException;
import com.course.model.vo.UserVo;
import com.course.service.UserService;

@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	/**
	 * 登入
	 * @param user
	 * @return
	 * @throws ActionException
	 */
	@PostMapping("/login")
	public ResponseEntity<UserVo> login(@RequestBody UserVo user) throws ActionException {
		UserVo userVo = userService.userLogin(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(userVo);
	}
	
	/**
	 * 登出
	 */
	@PostMapping("/logout")
	public void logout() {
		logger.info("User Logout");
		userService.logout();
	}
	
	
}
