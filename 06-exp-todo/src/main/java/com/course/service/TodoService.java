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
		
//		for (TodoDto dto : dtoList) {
//			dto.setMemo("XXXX");
//		}
		
//		dtoList.stream().forEach(d -> d.setMemo("XXXX"));
		
		List<TodoVo> result = dtoList.stream().map(dto -> helper.convertToVo(dto)).collect(Collectors.toList());
		
		List<TodoVo> resultList = new ArrayList<>();
		for (TodoDto todoDto : dtoList) {
//			TodoVo vo = new TodoVo();
//			vo.setId(todoDto.getId());
//			vo.setTitle(todoDto.getTitle());
//			vo.setDueDate(parseDateToString(todoDto.getDueDate()));
//			vo.setStatus(String.valueOf(todoDto.getStatus()));
//			vo.setStatusDisp(todoDto.getStatus() == 0 ? "未完成" : "已完成");
//			vo.setMemo(todoDto.getMemo());
//			vo.setUsername(todoDto.getUsername());
			TodoVo vo = helper.convertToVo(todoDto);
			resultList.add(vo);

		}
		
		return dtoList.stream().map(dto -> helper.convertToVo(dto)).collect(Collectors.toList());
	}
	
	private String parseDateToString(Date date) {
	     // 定義日期格式
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       // 將 Date 物件轉換為 String
       return formatter.format(date);
	}
}
