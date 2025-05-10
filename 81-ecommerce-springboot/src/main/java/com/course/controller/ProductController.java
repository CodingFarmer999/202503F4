package com.course.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.vo.ProductVo;
import com.course.service.ProductService;

@CrossOrigin(origins = { "http://localhost:3000" }, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 取得商品列表
	 * @return
	 */
	@GetMapping(value = { "/products" })
	public ResponseEntity<List<ProductVo>> getProductsByPage() {
		List<ProductVo> page = productService.getAllProduct();
		return ResponseEntity.ok(page);
	}

	/**
	 * 取得分頁商品
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = { "/products/{pageNo}/{pageSize}" })
	public ResponseEntity<Page<ProductVo>> getProductsByPage(@PathVariable Integer pageNo,
			@PathVariable Integer pageSize) {
		Page<ProductVo> page = productService.getProductsPage(pageNo, pageSize);
		return ResponseEntity.ok(page);
	}

	/**
	 * 新增/修改商品
	 * @param productVo
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/product", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<ProductVo> addProduct(@ModelAttribute ProductVo productVo) throws IOException {
		ProductVo product = productService.updateProduct(productVo);
		return ResponseEntity.ok(product);
	}
	

}
