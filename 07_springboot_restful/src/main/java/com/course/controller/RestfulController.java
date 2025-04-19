package com.course.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.User;

import io.swagger.v3.oas.annotations.Operation;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class RestfulController {

	@Operation(tags = { "HOME" })
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@Operation(summary = "取得使用者", description = "詳細描述", tags = { "USER-API" })
	@GetMapping("/users")
	public List<User> getAllUser() {
		User user1 = new User("Kitty", "aaa");
		User user2 = new User("Snoopy", "bbb");
		User user3 = new User("Bird", "ccc");
		return Arrays.asList(user1, user2, user3);
	}
	
	@Operation(summary = "新增使用者", description = "新增使用者", tags = { "USER-API" })
	@PostMapping("/user")
	public User addUser(User user) {
		System.out.println("user: " + user);
		// TODO: 新增使用者，自己做
		return user;
	}
	
	@Operation(summary = "新增使用者 RequestBody", description = "新增使用者", tags = { "USER-API" })
	@PostMapping("/user2")
	public User addUser2(@RequestBody User user) {
		System.out.println("user: " + user);
		// TODO: 新增使用者，自己做
		return user;
	}
	
	@GetMapping("/user/{id}/age/{age}")
	public User searchUser(@PathVariable Integer id, @PathVariable Integer age) {
		System.out.println(id);
		System.out.println(age);
		User user1 = new User("Kitty", "aaa");
		return user1;
	}
	
	@GetMapping("/user2/")
	public User searchUser2(@RequestParam Integer id, @RequestParam Integer age) {
		System.out.println(id);
		System.out.println(age);
		User user1 = new User("Kitty", "aaa");
		return user1;
	}
	
	
	@GetMapping("/ok")
	public ResponseEntity<String> ok() {
	    return ResponseEntity.ok("OK");
	}
	
	@GetMapping("/okUser")
	public ResponseEntity<User> okUser() {
	    return ResponseEntity.ok(new User("Kitty", "aaa"));
	}
	
	@GetMapping("/errorUser")
	public ResponseEntity<User> errorUser() {
		
	    return new ResponseEntity<>(new User("Kitty", "aaa"), HttpStatus.NOT_FOUND);
	}
}
	