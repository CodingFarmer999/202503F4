package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.TodoEntity;
import com.course.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public List<TodoEntity> getAllTodoList() {
		return todoService.getAllTodo();
	}
}
