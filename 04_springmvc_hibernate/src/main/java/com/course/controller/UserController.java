package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		boolean loginSuccess = userService.login(username, password);
		if (loginSuccess) {
			return "";
		} else {
			return "";
		}
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		userService.addUser(username, password);
		return "registerSuccess";
	}
}
