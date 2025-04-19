package com.course.controller;

import org.springframework.web.bind.annotation.RestController;

import com.course.service.TodoService;

@RestController
public class TodoController {

	private TodoService todoService;
}
