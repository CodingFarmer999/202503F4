package com.course.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.dto.ProductDto;
import com.course.entity.ProductEntity;
import com.course.exception.ActionException;
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

		// 先抽SEQ
		Long pId = productMapper.getProductSeq();
		vo.setId(pId);
		productMapper.insertProduct(vo);
		
		// 新增 ProductPrice
		productMapper.insertProductPrice(vo);
		
	}

	@Override
	public List<ProductVo> getAllProduct() {

		List<ProductDto> products = productMapper.findAll();
		
		List<ProductDto> dtos = productMapper.findAllReview();
		// Key: 1 Value : [買不到, 好貴, 好用]
		// Key: 2 Value : [無]
		Map<Long, List<String>> memoResult = dtos.stream().collect(Collectors.groupingBy(
				// 以 productId 作為 Key
                ProductDto::getProductId,
                // 以 memo 作為 List 來做 Value
                Collectors.mapping(ProductDto::getMemo, Collectors.toList()) 
            ));
		
		List<ProductVo> voList = products.stream().map(dto -> {
			ProductVo vo = new ProductVo();
			vo.setName(dto.getName());
			vo.setCode(dto.getCode());
			vo.setListPrice(dto.getListPrice());
			vo.setSalesPrice(dto.getSalesPrice());
			vo.setMemos(memoResult.get(dto.getId()));
//			List<ProductDto> reviews = productMapper.findReviewById(dto.getId());
//			List<String> memos = reviews.stream().map(ProductDto::getMemo).collect(Collectors.toList());
//			vo.setMemos(memos);
			// 各個欄位
			return vo;
		}).collect(Collectors.toList());
		

		
		return voList;
	}

//	@Override
//	public ProductVo getProductById(Long id) {
//		Integer.parseInt("ABC");
//		ProductDto dto = productMapper.findById(id);
//		ProductVo vo = new ProductVo();
//		vo.setName(dto.getName());
//		vo.setCode(dto.getCode());
//		vo.setListPrice(dto.getListPrice());
//		vo.setSalesPrice(dto.getSalesPrice());
//		return vo;
//	}
	
	@Override
	public ProductVo getProductById(Long id) throws ActionException {
		ProductVo vo = new ProductVo();
		try {
			Integer.parseInt("ABC");
			ProductDto dto = productMapper.findById(id);
			vo.setName(dto.getName());
			vo.setCode(dto.getCode());
			vo.setListPrice(dto.getListPrice());
			vo.setSalesPrice(dto.getSalesPrice());
		} catch (Exception e) {
			throw new ActionException("出事了");
		}

		return vo;
	}

	@Override
	public List<ProductDto> getAllProductData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getProductByCondition(ProductQueryParam queryParam) {
		String key = queryParam.getProductName();
		if (key != null && !key.isBlank()) {
			queryParam.setProductName("%" + key + "%");
		}

		List<ProductDto> products = productMapper.findByCondition(queryParam);
		
		return products;
	}

	@Override
	public List<ProductEntity> findProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> findByCategories(List<String> categories) {
		return productMapper.findByCategories(categories);
	}

	@Override
	public void updateProductPrice(ProductVo vo) {
		productMapper.updatePrice(vo);
	}

}
