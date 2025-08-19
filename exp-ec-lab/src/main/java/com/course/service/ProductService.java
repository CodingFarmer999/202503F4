package com.course.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.course.dto.ProductDto;
import com.course.entity.CategoryEntity;
import com.course.entity.ProductEntity;
import com.course.entity.ProductPriceEntity;
import com.course.entity.ProductReviewEntity;
import com.course.repository.ProductCustomRepository;
import com.course.repository.ProductPriceRepository;
import com.course.repository.ProductRepository;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

public class ProductService {
	
	/**
	 * 新增商品
	 * @param vo
	 */
	public void addProduct(ProductVo vo) {

		// 新增 Product 資料
		
		// 新增 ProductPrice 資料
		
	}
	
	/**
	 * 取得所有商品
	 * @return
	 */
	public List<ProductVo> getAllProduct() {
		// 取得所有商品
		List<ProductEntity> productList = null;
		
		return productList.stream().map(product -> {
			ProductVo vo = new ProductVo();
			// 取得 Entity 欄位資料，並放到 Vo 當中

			// 取得 Price 資料
			
			return vo;
		}).collect(Collectors.toList());
	}
	
	/**
	 * 透過ID取得商品
	 * @return
	 */
	public ProductVo getProductById(Long id) {
		// 取得所有商品
		ProductEntity product = null;
		ProductVo vo = new ProductVo();
		// 取得 Price 資料
		
		// 取得 多筆 Review 資料

		
		// 取得 多筆 Category 資料

		return vo;
	}
	
	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	public List<ProductDto> getAllProductData() {
		return null;
	}
	
	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	public List<ProductDto> getProductByCondition(ProductQueryParam queryParam) {
		return null;
	}
	
}
