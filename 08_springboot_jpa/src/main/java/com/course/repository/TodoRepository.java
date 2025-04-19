package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
