package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.course.model.TodoDto;
import com.course.model.TodoVo;

@Service
public class TodoServiceHelper {

	/**
	 * 物件轉換 
	 * Dto -> Vo
	 * @param todoDto
	 * @return
	 */
	public TodoVo convertToVo(TodoDto todoDto) {
		TodoVo vo = new TodoVo();
		vo.setId(todoDto.getId());
		vo.setTitle(todoDto.getTitle());
		vo.setDueDate(parseDateToString(todoDto.getDueDate()));
		vo.setStatus(String.valueOf(todoDto.getStatus()));
		vo.setStatusDisp(todoDto.getStatus() == 0 ? "未完成" : "已完成");
		vo.setMemo(todoDto.getMemo());
		vo.setUsername(todoDto.getUsername());
		return vo;
	}
	
	/**
	 * 物件轉換 
	 * Vo -> Dto
	 * @param todoVo
	 * @return
	 */
	public TodoDto convertToDto(TodoVo todoVo) {
		TodoDto dto = new TodoDto();
		dto.setId(todoVo.getId());
		// TODO: 取得使用者
		dto.setUserId(1L);
		dto.setTitle(todoVo.getTitle());
		dto.setDueDate(parseDate(todoVo.getDueDate()));
		dto.setStatus(Integer.valueOf(todoVo.getStatus()));
		dto.setMemo(todoVo.getMemo());
		return dto;
	}
	
	/**
	 * 轉換日期
	 * @param dueDateStr
	 * @return
	 */
	private Date parseDate(String dueDateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dueDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
	 * 日期轉換字串
	 * @param date
	 * @return
	 */
	private String parseDateToString(Date date) {
	     // 定義日期格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // 將 Date 物件轉換為 String
        return formatter.format(date);
	}
}
