package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.User;
import com.course.service.UserService;
import com.course.vo.UserVo;

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
			return "loginSuccess";
		} else {
			return "loginFail";
		}
	}
	
	@PostMapping("/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		userService.addUser(username, password);
		return "registerSuccess";
	}
	
	@GetMapping("/toUserList")
	public String findAllUser(Model model) {
		List<User> userList = userService.findAllUser();
		model.addAttribute("users", userList);
		return "userList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteByUserId(id);

		return "redirect:/toUserList";
	}
	
	@GetMapping("/toUpdate/{id}")
	public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		
		return "updateUser";
	}
	
	@PostMapping("/update")
	public String updateUser(UserVo userVo) {

		System.out.println(userVo);
		userService.upateUser(userVo);
		 return "redirect:/toUserList"; 
	}
}
