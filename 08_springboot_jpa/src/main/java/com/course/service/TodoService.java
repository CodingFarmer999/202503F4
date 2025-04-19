package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.TodoEntity;
import com.course.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public List<TodoEntity> getAllTodo() {
		return todoRepository.findAll();
	}
	
	public TodoEntity addTodo(TodoEntity entity) {
		return todoRepository.save(entity);
	}
}
