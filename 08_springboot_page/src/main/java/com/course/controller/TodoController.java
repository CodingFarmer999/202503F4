package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.TodoEntity;
import com.course.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo/page/")
	public Page<TodoEntity> getAllWithPage(Integer pageNum, Integer size) {
		return todoService.getAllWithPage(pageNum, size);
	}
	
	@GetMapping("/todoPagination2")
	public ResponseEntity<Page<TodoEntity>> getAllWithPage2(Pageable pageable) {
	    Page<TodoEntity> result = todoService.getAllWithPage2(pageable);
	    return ResponseEntity.ok().body(result);
	}
	
}
