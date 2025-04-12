package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestfulController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
