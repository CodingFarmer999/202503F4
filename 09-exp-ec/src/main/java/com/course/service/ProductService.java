package com.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.course.dto.ProductDto;
import com.course.entity.ProductEntity;
import com.course.exception.ActionException;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

public interface ProductService {

	/**
	 * 新增商品
	 * @param vo
	 */
	void addProduct(ProductVo vo);

	/**
	 * 取得所有商品
	 * @return
	 */
	List<ProductVo> getAllProduct();

	/**
	 * 透過ID取得商品
	 * @return
	 * @throws ActionException 
	 */
	ProductVo getProductById(Long id) throws ActionException;

	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	List<ProductDto> getAllProductData();

	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	List<ProductDto> getProductByCondition(ProductQueryParam queryParam);

	List<ProductEntity> findProduct();
	
	List<ProductDto> findByCategories(List<String> categories);
	
	void updateProductPrice(ProductVo vo);

}