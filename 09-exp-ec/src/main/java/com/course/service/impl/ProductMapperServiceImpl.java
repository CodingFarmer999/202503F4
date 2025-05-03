package com.course.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dto.ProductDto;
import com.course.entity.ProductEntity;
import com.course.mapper.ProductMapper;
import com.course.service.ProductService;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

@Service
public class ProductMapperServiceImpl implements ProductService {

	@Autowired
	private  ProductMapper productMapper;
	
	@Override
	public void addProduct(ProductVo vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductVo> getAllProduct() {
		List<ProductDto> products = productMapper.findAll();
		List<ProductVo> voList = products.stream().map(dto -> {
			ProductVo vo = new ProductVo();
			vo.setName(dto.getName());
			vo.setCode(dto.getCode());
			vo.setListPrice(dto.getListPrice());
			vo.setSalesPrice(dto.getSalesPrice());
			// 各個欄位
			return vo;
		}).collect(Collectors.toList());
		
		for (ProductDto dto : products) {
			List<ProductDto> reviews = productMapper.findReviewById(dto.getId());
		}
		
		return voList;
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
