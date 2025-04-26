package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.course.entity.TodoEntity;
import com.course.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	
	public Page<TodoEntity> getAllWithPage(Integer pageNum, Integer size) {
		Pageable pageable = PageRequest.of(pageNum, size);
		return todoRepository.findAll(pageable);
	}
	
	public Page<TodoEntity> getAllWithPage2(Pageable pageable) {
		return todoRepository.findAll(pageable);
	}
	
	
}
