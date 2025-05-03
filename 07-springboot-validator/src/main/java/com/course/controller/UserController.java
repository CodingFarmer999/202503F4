package com.course.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.User;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@PostMapping("/user")
	public String addUser(@RequestBody @Valid User user) {
		return "OK";
	}
}
