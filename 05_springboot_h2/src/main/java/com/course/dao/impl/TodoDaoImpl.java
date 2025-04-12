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

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" * ");
		sb.append(" FROM TODO ");
		sb.append(" WHERE TITLE LIKE ? ");
		RowMapper<TodoDto> rowMapper = (rs, num) -> {
	        TodoDto dto = new TodoDto();
	        dto.setId(rs.getLong("id"));
	        dto.setTitle(rs.getString("title"));
	        dto.setDueDate(rs.getDate("dueDate"));
	        dto.setStatus(rs.getInt("status"));
	        return dto;
		};
		List<TodoDto> dtoList = jdbcTemplate.query(sb.toString(), rowMapper, "%" + title + "%");
		
		return dtoList;
	}
	
	@Override
	public List<TodoDto> findByTitle2(String title, String temp) {

		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" * ");
		sb.append(" FROM TODO ");
		sb.append(" WHERE ID IS NOT NULL ");
		
		if (title != null && !title.isBlank()) {
			sb.append("AND TITLE = ? ");
		}
		
		if (temp != null && !temp.isBlank()) {
			sb.append("AND TEMP = ? ");
		}
		
		RowMapper<TodoDto> rowMapper = (rs, num) -> {
	        TodoDto dto = new TodoDto();
	        dto.setId(rs.getLong("id"));
	        dto.setTitle(rs.getString("title"));
	        dto.setDueDate(rs.getDate("dueDate"));
	        dto.setStatus(rs.getInt("status"));
	        return dto;
		};
		List<TodoDto> dtoList = jdbcTemplate.query(sb.toString(), rowMapper, "%" + title + "%");
		
		return dtoList;
	}

}
