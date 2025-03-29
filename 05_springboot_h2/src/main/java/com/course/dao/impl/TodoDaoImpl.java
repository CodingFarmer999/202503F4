package com.course.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String sql ="UPDATE TODO SET TITLE = ?, DUEDATE = ?, STATUS = ? WHERE ID = ?";
		jdbcTemplate.update(sql, todoDto.getTitle(), todoDto.getDueDate(), todoDto.getStatus(), todoDto.getId());
		
	}

	@Override
	public void delete(Long id) {
		String sql ="DELETE FROM TODO WHERE ID = ?";
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public List<TodoDto> findAll() {
		String sql = "SELECT * FROM TODO";
		
		RowMapper<TodoDto> rowMapper = new RowMapper<>() {

			@Override
			public TodoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				TodoDto dto = new TodoDto();
				dto.setId(rs.getLong("ID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setDueDate(rs.getDate("DUEDATE"));
				dto.setStatus(rs.getInt("STATUS"));
				
				return dto;
			}
		};
		List<TodoDto> dtoList = jdbcTemplate.query(sql, rowMapper);
		return dtoList;
	}

	@Override
	public List<TodoDto> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
