package com.course.dao;

import com.course.model.TodoDto;

public interface TodoDao {

	void add(TodoDto todoDto);
	
	void update(TodoDto todoDto);
	
	void delete(Long id);
}
