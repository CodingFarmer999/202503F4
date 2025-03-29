package com.course.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.course.dao.TodoDao;
import com.course.model.TodoDto;

@Repository
public class TodoDaoImpl implements TodoDao {

	Logger logger = LoggerFactory.getLogger(TodoDaoImpl.class);
	
	/** 自動裝配 JdbcTemplate  */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TodoDto> findAll() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		// sb.append("*");
		sb.append("T.ID, ");
		sb.append("T.TITLE, ");
		sb.append("T.DUE_DATE, ");
		sb.append("T.STATUS, ");
		sb.append("T.MEMO, ");
		sb.append("U.USERNAME ");
		sb.append("FROM TODO T ");
		sb.append("JOIN USER U ON U.ID = T.USERID ");
		// String sql = "SELECT * FROM TODO T";
		
		RowMapper<TodoDto> rowMapper = (rs, rowNum) -> {
			TodoDto dto = new TodoDto();
			dto.setId(rs.getLong("ID"));
			dto.setTitle(rs.getString("TITLE"));
			dto.setDueDate(rs.getDate("DUE_DATE"));
			dto.setStatus(rs.getInt("STATUS"));
			dto.setMemo(rs.getString("MEMO"));
			dto.setUsername(rs.getString("USERNAME"));
			return dto;
		};
		return jdbcTemplate.query(sb.toString(), rowMapper);
	}

	@Override
	public Integer add(TodoDto todoDto) {
		String sql = "INSERT INTO TODO (USERID, TITLE, DUE_DATE, STATUS, MEMO) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, todoDto.getUserId(), todoDto.getTitle(), todoDto.getDueDate(), todoDto.getStatus(), todoDto.getMemo());
		
	}

	@Override
	public Integer delete(Long id) {
		String sql = "DELETE FROM TODO WHERE ID = ?";
		// 會回傳成功的筆數
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Integer update(TodoDto todoDto) {
		String sql = "UPDATE TODO SET TITLE = ?, DUE_DATE = ?, STATUS = ?, MEMO = ? WHERE ID = ?";
		return jdbcTemplate.update(sql, todoDto.getTitle(), todoDto.getDueDate(), todoDto.getStatus(), todoDto.getMemo(), todoDto.getId());
	}

	@Override
	public TodoDto findById(Long id) {

		String sql = "SELECT * FROM TODO WHERE ID = ?";
		RowMapper<TodoDto> rowMapper = new RowMapper<>() {
			@Override
			public TodoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				TodoDto dto = new TodoDto();
				dto.setId(rs.getLong("id"));
				dto.setTitle(rs.getString("title"));
				dto.setDueDate(rs.getDate("due_date"));
				dto.setStatus(rs.getInt("status"));
				dto.setMemo(rs.getString("memo"));
				return dto;
			}
		};
		
		TodoDto result = null;
		try {
			result = jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			logger.info("查無資料");
		}
		
		return result;
	}

}
