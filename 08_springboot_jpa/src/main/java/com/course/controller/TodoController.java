package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/todo")
	public TodoEntity addTodo(@RequestBody TodoEntity entity) {
		System.out.println(entity);
		return todoService.addTodo(entity);
	}
	
	@DeleteMapping("/todos")
	public String deleteAll() {
		todoService.deleteAll();
		return "OK";
	}
	
	@DeleteMapping("/todos/batch")
	public String deleteAllInBatch() {
		todoService.deleteAllInBatch();
		return "OK";
	}
	
	
	@PatchMapping("/todo")
	public TodoEntity updateTodo(@RequestBody TodoEntity entity) {
		return todoService.updateTodo(entity);
	}
}
