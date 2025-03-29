package com.course.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.course.dao.TodoDao;
import com.course.model.TodoDto;

@Repository
public class TodoDaoImpl implements TodoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(TodoDto todoDto) {
		String sql = "INSERT INTO TODO (TITLE, DUEDATE, STATUS) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, todoDto.getTitle(), todoDto.getDueDate(), todoDto.getStatus());
	}

	@Override
	public void update(TodoDto todoDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
