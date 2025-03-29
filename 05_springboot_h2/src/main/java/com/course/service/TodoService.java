package com.course.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.TodoDao;
import com.course.model.TodoDto;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;
	
	public void addTodo() {
		TodoDto dto = new TodoDto();
		dto.setTitle("吃飯2");
		dto.setDueDate(new Date());
		dto.setStatus(0);
		todoDao.add(dto);
	}
	
	public List<TodoDto> findAll() {
		List<TodoDto> dtos = todoDao.findAll();
		return dtos;
	}
	
	public List<TodoDto> findByTitle() {
		List<TodoDto> dtos = todoDao.findByTitle("菜");
		return dtos;
	}
}
