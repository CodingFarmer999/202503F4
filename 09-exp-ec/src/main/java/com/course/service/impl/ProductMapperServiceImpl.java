package com.course.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.course.dto.ProductDto;
import com.course.entity.ProductEntity;
import com.course.service.ProductService;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

@Service
public class ProductMapperServiceImpl implements ProductService {

	@Override
	public void addProduct(ProductVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductVo> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductVo getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getAllProductData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getProductByCondition(ProductQueryParam queryParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
