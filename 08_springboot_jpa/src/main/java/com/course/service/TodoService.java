package com.course.service;

import java.util.List;
import java.util.Optional;

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
	
	public void deleteAll() {
		todoRepository.deleteAll();
	}
	
	public void deleteAllInBatch() {
		todoRepository.deleteAllInBatch();
	}
	
	// id Title
	public TodoEntity updateTodo(TodoEntity entity) {
		
//		Long id = entity.getId();
//		Optional<TodoEntity> option = todoRepository.findById(id);
//		
//		if (option.isPresent()) {
//			TodoEntity todo = option.get();
//			todo.setTitle(entity.getTitle());
//			todoRepository.save(todo);
//		}
		
		TodoEntity todo2 = todoRepository.findById(entity.getId()).orElse(null);
		todo2.setTitle(entity.getTitle());
		todoRepository.save(todo2);

		return null;
	}

}
