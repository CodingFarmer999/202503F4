package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@ModelAttribute("title")
	public String title() {
		return "待辦事項XXXXYYYY";
	}
}
