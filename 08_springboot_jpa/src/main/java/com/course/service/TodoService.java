package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.course.dto.TodoDto;
import com.course.entity.TodoEntity;
import com.course.repository.TodoRepository;

import jakarta.transaction.Transactional;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public List<TodoEntity> getAllTodo() {
		return todoRepository.findAll();
	}
	
	public TodoEntity addTodo(TodoEntity entity) {
		TodoEntity todo = todoRepository.save(entity);
		return todo;
	}
	
	public void deleteAll() {
		todoRepository.deleteAll();
	}
	
	public void deleteAllInBatch() {
		todoRepository.deleteAllInBatch();
	}
	
	// id Title
	public TodoEntity updateTodo(TodoEntity entity) {
		
//		Long id = entity.getId();
//		Optional<TodoEntity> option = todoRepository.findById(id);
//		
//		if (option.isPresent()) {
//			TodoEntity todo = option.get();
//			todo.setTitle(entity.getTitle());
//			todoRepository.save(todo);
//		}
		
		TodoEntity todo2 = todoRepository.findById(entity.getId()).orElse(null);
		todo2.setTitle(entity.getTitle());
		return todoRepository.save(todo2);
	}
	
	public List<TodoEntity> getByTitle(String title) {
		return todoRepository.findByTitle(title);
	}
	
	public List<TodoEntity> getByTitleAndUnComplete(String title, Integer status) {
		return todoRepository.findByTitleAndStatus(title, status);
	}
	
	public List<TodoEntity> getByDueDate(Date dueDate) {
		
		System.out.println(dueDate);
		return todoRepository.findByDueDate(dueDate);
	}
	
	public List<TodoEntity> findByDueDateGreaterThan(Date dueDate) {
		
		System.out.println(dueDate);
		return todoRepository.findByDueDateGreaterThan(dueDate);
	}
	
	public List<TodoEntity> findByDueDateBetween(String startDate, String endDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date start = null;
		Date end = null;
		try {
			// 2025/04/19 00:00:00
		    start = dateFormat.parse(startDate + " 00:00:00");
		    end = dateFormat.parse(endDate + " 23:59:59");
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return todoRepository.findByDueDateBetween(start, end);
	}
	
	public List<TodoEntity> findByTitleLike(String keyword) {
		
		System.out.println(keyword);
		// where title like '%AAA'
		return todoRepository.findByTitleLike("%" +keyword + "%");
	}
	
	public List<TodoEntity> findByIdIn(List<Long> ids) {
		
		System.out.println(ids);
		// where title like '%AAA'
		return todoRepository.findByIdIn(ids);
	}
	
	public List<TodoEntity> findOrderTitle() {
		return todoRepository.findAllByOrderByTitleDesc();
	}
	
	public Integer countByStatus(Integer status) {
		return todoRepository.countByStatus(status);
	}

	
	public List<TodoEntity> findByCondition(String title, Integer status) {
		return todoRepository.findByCondition(title, status);
	}
	
	@Transactional
	public Integer updateQuery(Long id, String title) {
		return todoRepository.updateTodo(id, title);
	}
	
	public List<TodoEntity> getByTitleSort(String title) {
//		Sort sort = Sort.by("dueDate");
		Sort sort = Sort.by(Sort.Order.desc("dueDate"));
		return todoRepository.findByTitle(title, sort);
	}
	
	public List<TodoDto> findUser() {
		List<TodoDto> dtoList = todoRepository.getTodoDtoList();
		return dtoList;
	}
	
}
