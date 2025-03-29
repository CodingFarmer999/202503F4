package com.course.dao;

import java.util.List;

import com.course.model.TodoDto;

public interface TodoDao {

	void add(TodoDto todoDto);
	
	void update(TodoDto todoDto);
	
	void delete(Long id);
	
	List<TodoDto> findAll();
	
	List<TodoDto> findByTitle(String title);
	
	List<TodoDto> findByTitle2(String title, String temp);
}
