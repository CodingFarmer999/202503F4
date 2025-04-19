package com.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

	// SQL : select * from todo where title = ?
	public List<TodoEntity> findByTitle(String title);
	
	List<TodoEntity> findByDueDate(Date dueDate);
	
	// SQL : select * from todo where title = ? and status = ?
	List<TodoEntity> findByTitleAndStatus(String title, Integer status);
}
