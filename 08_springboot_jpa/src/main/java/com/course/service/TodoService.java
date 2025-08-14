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
	
	/**
	 * 取得所有待辦事項
	 * @return
	 */
	public List<TodoEntity> getAllTodo() {
		return todoRepository.findAll();
	}
	
	/**
	 * 依照 ID 取得待辦事項
	 * findById 取得的是 Optional 物件
	 * 需要明確處理沒有值的狀況
	 * @param id
	 * @return
	 */
	public TodoEntity findTodoById(Long id) {
		return todoRepository.findById(id).orElse(null);
	}
	
	/**
	 * 新增待辦事項
	 * save 方法會回傳一個 Entity 物件
	 * 如果使用"自增主鍵" 或是 "序列"，回傳的 Entity 會帶有本次新增時所產生的鍵值
	 * @param entity
	 * @return
	 */
	public TodoEntity addTodo(TodoEntity entity) {
		TodoEntity todo = todoRepository.save(entity);
		return todo;
	}
	
	/**
	 * 刪除 所有待辦事項
	 * 原生的 deleteAll，會先把資料的所有ID找出來，並依照ID去逐筆刪除資料
	 */
	public void deleteAll() {
		todoRepository.deleteAll();
	}
	
	/**
	 * 批次刪除 所有待辦事項
	 * 一次刪除所有資料
	 */
	public void deleteAllInBatch() {
		todoRepository.deleteAllInBatch();
	}
	
	/**
	 * 刪除待辦事項 By ID
	 */
	public void deleteTodoById(Long id) {
		todoRepository.deleteById(id);
	}
	
	/**
	 * 刪除待辦事項 By Entity
	 */
	public void delete(Long id) {
		TodoEntity entity = findTodoById(id);
		todoRepository.delete(entity);
	}
	
	/**
	 * 更新 待辦事項
	 * 傳入的物件當中，有鍵值以及要更新的資料
	 * save的操作方法是 Entity，所以需要先透過 ID 取得 Entity，再更新當中的內容
	 * @param entity
	 * @return
	 */
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
	
	/**
	 * 依照標題取得待辦事項
	 * @param title
	 * @return
	 */
	public List<TodoEntity> getTodoByTitle(String title) {
		return todoRepository.findByTitle(title);
	}
	
	/**
	 * 依照標題以及狀態取得代辦事項
	 * @param title
	 * @param status
	 * @return
	 */
	public List<TodoEntity> getTodoByTitleAndStatus(String title, Integer status) {
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
	
	public List<TodoEntity> getTodoByTitleWithSort(String title) {
		// 依到期日排序昇冪排序
		// Sort sort = Sort.by("dueDate");
		
		// 如果需要降冪排序，需要使用 Sort.Order
		// 後面可以接受多個排序條件
		Sort sort = Sort.by(Sort.Order.desc("dueDate"));
		return todoRepository.findByTitle(title, sort);
	}
	
	public List<TodoDto> findUser() {
		List<TodoDto> dtoList = todoRepository.getTodoDtoList();
		return dtoList;
	}
	
}
