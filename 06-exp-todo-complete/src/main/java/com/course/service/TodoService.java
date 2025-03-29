package com.course.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.TodoDao;
import com.course.model.SearchCondition;
import com.course.model.TodoDto;
import com.course.model.TodoVo;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;
	
	@Autowired
	private TodoServiceHelper helper;
	
	public List<TodoVo> getAllTodoList() {
		List<TodoDto> dtoList = todoDao.findAll();
		return dtoList.stream().map(dto -> helper.convertToVo(dto)).collect(Collectors.toList());
	}
	
	/**
	 * 新增待辦事項
	 * @param todoVo
	 */
	public void addTodo(TodoVo todoVo) {
		
		// 新增代辦事項，狀態固定為0(未完成)
		todoVo.setStatus("0");
		
		// 轉換 Vo -> Dto
		TodoDto dto = helper.convertToDto(todoVo);
		todoDao.add(dto);
	}
	
	/**
	 * 刪除待辦事項
	 * @param id
	 */
	public void deleteTodo(Long id) {
		todoDao.delete(id);
	}
	
	/**
	 * 更新待辦事項
	 * @param todoVo
	 */
	public void updateTodo(TodoVo todoVo) {
		TodoDto dto = helper.convertToDto(todoVo);
		todoDao.update(dto);
	}

	/**
	 * 透過 ID 搜尋
	 * @param id
	 * @return
	 */
	public TodoVo getTodoById(Long id) {
		TodoDto dto = todoDao.findById(id);
		return helper.convertToVo(dto);
	}
	
	public List<TodoVo> searchByCondition(SearchCondition condition) {
		List<TodoDto> dtoList = todoDao.findByCondition(condition);
		return dtoList.stream().map(dto -> helper.convertToVo(dto)).collect(Collectors.toList());
	}
	
}
