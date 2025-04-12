package com.course.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.TodoDao;
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
		
		// 以下寫法同義
//		for (TodoDto dto : dtoList) {
//			dto.setMemo("XXXX");
//		}
//		dtoList.stream().forEach(d -> d.setMemo("XXXX"));
		
		// 以下寫法同義
//		List<TodoVo> resultList = new ArrayList<>();
//		for (TodoDto todoDto : dtoList) {
//			TodoVo vo = helper.convertToVo(todoDto);
//			resultList.add(vo);
//		}
//		return resultList;
		
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
	
}
