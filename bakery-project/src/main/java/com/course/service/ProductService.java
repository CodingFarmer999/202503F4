package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dao.ProductDao;
import com.course.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	/**
	 * 新增商品
	 * @param name
	 * @param descript
	 * @param img
	 * @param price
	 * @param category
	 * @return
	 */
	public Integer addProduct(String name, String descript, String img, Integer price, String category) {
		return dao.addProduct(name, descript, img, price, category);
	}
	
	/**
	 * 搜尋全部商品
	 * @return
	 */
	public List<Product> findAllProduct() {
		return dao.findAll();
	}
	
	/**
	 * 透過Id搜尋商品
	 * @param id
	 * @return
	 */
	public Product findById(Integer id) {
		return dao.findById(id);
	}
	
	/**
	 * 更新商品資料
	 * @param id
	 * @param name
	 * @param descript
	 * @param img
	 * @param price
	 * @param category
	 * @return
	 */
	public Integer update(Long id, String name, String descript, String img, Integer price, String category) {
		return dao.update(id, name, descript, img, price, category);
	}
	
	/**
	 * 刪除
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id) {
		return dao.delete(id);
	}
}
