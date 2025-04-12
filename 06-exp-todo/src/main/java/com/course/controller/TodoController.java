package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.course.model.TodoVo;
import com.course.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String home() {
		List<TodoVo> todoList= todoService.getAllTodoList();
		return "index";
	}
	
	@ModelAttribute("title")
	public String title() {
		return "<script>alert('XXXXXX')</script>";
	}
}
