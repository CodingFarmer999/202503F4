package com.course.service.impl;

import java.util.ArrayList;
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
import com.course.service.ProductService;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

@Service
public class ProductJpaServiceImpl implements ProductService {

	// Repository
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductPriceRepository productPriceRepository;
	
	@Autowired
	private ProductCustomRepository customRepository;
	
	/**
	 * 新增商品
	 * @param vo
	 */
	@Override
	@Transactional
	public void addProduct(ProductVo vo) {
		// 新增 Product 資料
		ProductEntity entity = new ProductEntity();
		entity.setCode(vo.getCode());
		entity.setName(vo.getName());
		entity = productRepository.save(entity);

		// 出錯拉
		// Integer.parseInt("ABC");
		
		// 新增 ProductPrice 資料
		ProductPriceEntity priceEntity = new ProductPriceEntity();
		priceEntity.setListPrice(vo.getListPrice());
		priceEntity.setSalesPrice(vo.getListPrice());
//		priceEntity.setProductId(entity.getId());
		productPriceRepository.save(priceEntity);
	}
	
	/**
	 * 取得所有商品
	 * @return
	 */
	@Override
	public List<ProductVo> getAllProduct() {
		// 取得所有商品
		List<ProductEntity> productList = productRepository.findAll();
		
		return productList.stream().map(product -> {
			ProductVo vo = new ProductVo();
			// 取得 Entity 欄位資料，並放到 Vo 當中
			vo.setCode(product.getCode());
			vo.setName(product.getName());

			// 取得 Price 資料
			vo.setListPrice(product.getProductPrice().getListPrice());
			vo.setSalesPrice(product.getProductPrice().getSalesPrice());
			
			if (!CollectionUtils.isEmpty(product.getReviews())) {
//				List<String> memos = product.getReviews().stream().map(ProductReviewEntity::getMemo).collect(Collectors.toList());
//				vo.setMemos(memos);
				
				List<String> result = new ArrayList<>();
				for (ProductReviewEntity entity : product.getReviews()) {
					result.add(entity.getMemo());
				}

				vo.setMemos(result);

			}
			
			if (!CollectionUtils.isEmpty(product.getCategoryList())) {
				
				List<String> categories = product.getCategoryList().stream().map(CategoryEntity::getName).collect(Collectors.toList());
				vo.setCategories(categories);
			}
			
			return vo;
		}).collect(Collectors.toList());
	}
	
	/**
	 * 透過ID取得商品
	 * @return
	 */
	@Override
	public ProductVo getProductById(Long id) {
		// 取得所有商品
		ProductEntity product = null;
		ProductVo vo = new ProductVo();
		vo.setCode(product.getCode());
		vo.setName(product.getName());
		// 取得 Price 資料
		vo.setListPrice(product.getProductPrice().getListPrice());
		vo.setSalesPrice(product.getProductPrice().getSalesPrice());
		
		// 取得 多筆 Review 資料

		
		// 取得 多筆 Category 資料

		return vo;
	}
	
	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	@Override
	public List<ProductDto> getAllProductData() {
		return customRepository.findAllProductData();
	}
	
	/**
	 * 取得所有商品，使用EntityManager
	 * @return
	 */
	@Override
	public List<ProductDto> getProductByCondition(ProductQueryParam queryParam) {
		return customRepository.findByCondition(queryParam);
	}
	
	@Override
	public List<ProductEntity> findProduct() {
		List<ProductEntity> products = productRepository.findAll();
		return products;
	}

	@Override
	public List<ProductDto> findByCategories(List<String> categories) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProductPrice(ProductVo vo) {
		// TODO Auto-generated method stub
		
	}
	
}
