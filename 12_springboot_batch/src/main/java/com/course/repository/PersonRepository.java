package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
