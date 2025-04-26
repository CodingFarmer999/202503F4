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

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductPriceRepository priceRepository;
	
	@Autowired
	private ProductCustomRepository customRepository;
	
	/**
	 * 新增商品
	 * @param vo
	 */
	@Transactional
	public void addProduct(ProductVo vo) {
		ProductEntity entity = new ProductEntity();
		entity.setCode(vo.getCode());
		entity.setName(vo.getName());
		
		entity = productRepository.save(entity);
		
		ProductPriceEntity priceEntity = new ProductPriceEntity();
		priceEntity.setListPrice(vo.getListPrice());
		priceEntity.setSalesPrice(vo.getSalesPrice());
		priceEntity.setProduct(entity);
		priceRepository.save(priceEntity);
	}
	
	/**
	 * 取得所有商品
	 * @return
	 */
	public List<ProductVo> getAllProduct() {
		List<ProductEntity> productList =  productRepository.findAll();
		
		return productList.stream().map(product -> {
			ProductVo vo = new ProductVo();
			vo.setCode(product.getCode());
			vo.setName(product.getName());
			vo.setListPrice(product.getProductPrice().getListPrice());
			vo.setSalesPrice(product.getProductPrice().getSalesPrice());
			return vo;
		}).collect(Collectors.toList());
	}
	
	/**
	 * 透過ID取得商品
	 * @return
	 */
	public ProductVo getProductById(Long id) {
		ProductEntity product =  productRepository.findById(id).orElse(null);
		ProductVo vo = new ProductVo();
		vo.setCode(product.getCode());
		vo.setName(product.getName());
		vo.setListPrice(product.getProductPrice().getListPrice());
		vo.setSalesPrice(product.getProductPrice().getSalesPrice());
		if (!CollectionUtils.isEmpty(product.getReviews())) {
			
			List<String> memos = product.getReviews().stream().map(ProductReviewEntity::getMemo).collect(Collectors.toList());
			vo.setMemos(memos);
		}
		
		if (!CollectionUtils.isEmpty(product.getCategoryList())) {
			
			List<String> categories = product.getCategoryList().stream().map(CategoryEntity::getName).collect(Collectors.toList());
			vo.setCategories(categories);
		}
		return vo;
	}
	
	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	public List<ProductDto> getAllProductData() {
		return customRepository.findAllProductData();
	}
	
	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	public List<ProductDto> getProductByCondition(ProductQueryParam queryParam) {
		return customRepository.findByCondition(queryParam);
	}
	
}
