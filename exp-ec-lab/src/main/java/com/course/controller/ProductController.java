package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.ProductDto;
import com.course.service.ProductService;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ec")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Operation(summary = "新增商品", tags = "商品")
	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestBody ProductVo vo) {
		productService.addProduct(vo);
		return ResponseEntity.ok().body("OK");
	}
	
	@Operation(summary = "取得所有商品", tags = "商品")
	@GetMapping("/products")
	public ResponseEntity<List<ProductVo>> getAllProduct() {
		List<ProductVo> productList = productService.getAllProduct();
		return ResponseEntity.ok().body(productList);
	}
	
	@Operation(summary = "依ID取得商品", tags = "商品")
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductVo> getProductById(@PathVariable Long id) {
		ProductVo product = productService.getProductById(id);
		return ResponseEntity.ok().body(product);
	}
	
	@Operation(summary = "取得所有商品(EntityManager)", tags = "商品")
	@GetMapping("/products2")
	public ResponseEntity<List<ProductDto>> getAllProductData() {
		List<ProductDto> productList = productService.getAllProductData();
		return ResponseEntity.ok().body(productList);
	}
	
	@Operation(summary = "依條件取得商品(EntityManager)", tags = "商品")
	@GetMapping("/product/search")
	public ResponseEntity<List<ProductDto>> getProductByCondition(ProductQueryParam queryParam) {
		List<ProductDto> productList = productService.getProductByCondition(queryParam);
		return ResponseEntity.ok().body(productList);
	}
	
}
