package com.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContoller {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
