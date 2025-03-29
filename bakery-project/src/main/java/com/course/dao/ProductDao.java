package com.course.dao;

import java.util.List;

import com.course.entity.Product;

public interface ProductDao {
	// Create
	public Integer addProduct(String name, String descript, String img, Integer price, String category);
	
	// Read
	public List<Product> findAll();
	
	public Product findById(Integer id);
	
	// Update
	public Integer update(Long id, String name, String descript, String img, Integer price, String category);
	
	// Delete
	public Integer delete(Long id);

}
