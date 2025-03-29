package com.course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
