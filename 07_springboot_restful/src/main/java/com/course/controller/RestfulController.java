package com.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.User;

//@Controller
//@ResponseBody
@RestController
public class RestfulController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		User user1 = new User("Kitty", "aaa");
		User user2 = new User("Snoopy", "bbb");
		User user3 = new User("Bird", "ccc");
		return Arrays.asList(user1, user2, user3);
	}
}
