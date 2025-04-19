package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
}
