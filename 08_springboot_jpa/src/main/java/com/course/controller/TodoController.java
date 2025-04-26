package com.course.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.TodoDto;
import com.course.entity.TodoEntity;
import com.course.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;

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
	
	@GetMapping("/todo/title/{title}")
	public List<TodoEntity> getByTitle(@PathVariable String title) {
		return todoService.getByTitle(title);
	}
	
	@Operation(summary = "找出未完成的待辦事項")
	@GetMapping("/todoUnComplete")
	public List<TodoEntity> getByTitleAndUnComplete(String title, Integer status) {
		return todoService.getByTitleAndUnComplete(title, status);
	}
	
	@Operation(summary = "找出未完成的待辦事項")
	@GetMapping("/todoByDate")
	public List<TodoEntity> getByDueDate(Date dueDate) {
		return todoService.getByDueDate(dueDate);
	}
	
	@Operation(summary = "找出大於到期日的待辦事項")
	@GetMapping("/findByDueDateGreaterThan")
	public List<TodoEntity> findByDueDateGreaterThan(Date dueDate) {
		return todoService.findByDueDateGreaterThan(dueDate);
	}
	
	@Operation(summary = "找出到期日區間的待辦事項")
	@GetMapping("/findByDueDateBetween")
	public List<TodoEntity> findByDueDateBetween(String start, String end) {
		return todoService.findByDueDateBetween(start, end);
	}
	
	@GetMapping("/todo/keyword/{keyword}")
	public List<TodoEntity> findByTitleLike(@PathVariable String keyword) {
		return todoService.findByTitleLike(keyword);
	}
	
	@GetMapping("/todo/ids")
	public List<TodoEntity> findByIdIn() {
		return todoService.findByIdIn(Arrays.asList(10L, 11L, 13L));
	}
	
	@GetMapping("/todo/orderTitle")
	public List<TodoEntity> findOrderTitle() {
		return todoService.findOrderTitle();
	}
	
	@GetMapping("/todo/count")
	public Integer countByStatus(Integer status) {
		return todoService.countByStatus(status);
	}
	
	@GetMapping("/todo/condition")
	public List<TodoEntity> findByCondition(String title, Integer status) {
		return todoService.findByCondition(title, status);
	}
	
	@Operation(summary = "更新待辦事項Title", tags = "@Query")
	@PostMapping("/update/todo")
	public Integer updateQuery(Long id, String title) {
		return todoService.updateQuery(id, title);
	}
	
	@Operation(summary = "取得並排序", tags = "@QueryMethod")
	@GetMapping("/todo/titleSort/{title}")
	public List<TodoEntity> getByTitleSort(@PathVariable String title) {
		return todoService.getByTitleSort(title);
	}
	@Operation(summary = "取得使用者", tags = "@QueryMethod")
	@GetMapping("/todo/user")
	public List<TodoDto> findUser() {
		return todoService.findUser();
	}
	
	
}
