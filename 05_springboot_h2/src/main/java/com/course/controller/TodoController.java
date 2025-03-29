package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.course.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/add")
	public String addTodo() {
		todoService.addTodo();
		return "index";
	}
	
	@GetMapping("/all")
	public String findAllTodo() {
		todoService.findAll();
		return "index";
	}
	
	@GetMapping("/title")
	public String findByTitle() {
		todoService.findByTitle();
		return "index";
	}
}
