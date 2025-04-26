package com.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

	// SQL : select * from todo where title = ?
	public List<TodoEntity> findByTitle(String title);
	
	List<TodoEntity> findByDueDate(Date dueDate);
	
	// SQL : select * from todo where title = ? and status = ?
	List<TodoEntity> findByTitleAndStatus(String title, Integer status);
	
	// SQL語句：select * from todo where due_date > ?
	List<TodoEntity> findByDueDateGreaterThan(Date dueDate);
	
	// SQL語句：select * from todo where due_date between ? and ?
	List<TodoEntity> findByDueDateBetween(Date startDate, Date endDate);
	
	// SQL語句：select * from todo where title like ?
	List<TodoEntity> findByTitleLike(String title);
	
	// SQL語句：select * from todo where id in (?, ?, ?);
	List<TodoEntity> findByIdIn(List<Long> ids);
	
	// SQL語句：select * from todo order by title;
	List<TodoEntity> findAllByOrderByTitleDesc();
	
	// SQL語句：select count(*) from todo where status = ?;
	Integer countByStatus(Integer status);
	
//	@Query(value = "select t from TodoEntity t where t.title = ?1 and t.status = ?2")
//	@Query(value = "select t from TodoEntity t where t.status = :status and t.title = :title")
	@Query(nativeQuery = true , value = "select * from todo t where t.status = :status and t.title = :title")
	List<TodoEntity> findByCondition(@Param("title") String t1, Integer status);
	
	@Modifying
	@Query("update TodoEntity set title = ?2 where id = ?1")
	Integer updateTodo(Long id, String title);
	
	public List<TodoEntity> findByTitle(String title, Sort sort);
	
	public Page<TodoEntity> findAll(Pageable pageable);
	
}
