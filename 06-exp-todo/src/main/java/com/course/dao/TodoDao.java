package com.course.dao;

import java.util.List;

import com.course.model.TodoDto;

public interface TodoDao {
	/**
	 * 新增待辦事項
	 * @param todoDto
	 */
	Integer add(TodoDto todoDto);
	
	/**
	 * 刪除待辦事項
	 * @param id
	 */
	Integer delete(Long id);
	
	/**
	 * 更新待辦事項
	 * @param todoDto
	 * @return
	 */
	Integer update(TodoDto todoDto);
	
	/**
	 * 取得全部待辦事項
	 * @return
	 */
	List<TodoDto> findAll();
	
	/**
	 * 透過 ID 搜尋
	 * @param id
	 * @return
	 */
	TodoDto findById(Long id);
	
//	List<TodoDto> findByCondition(SearchCondition condition);
}
