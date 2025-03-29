package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.course.entity.Product;
import com.course.service.ProductService;

@CrossOrigin(value = "http://localhost:3000")
@Controller
public class BakeryController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	@ResponseBody
	public String addProduct(String name, String descript, String img, Integer price, String category) {
		service.addProduct(name, descript, img, price, category);
		return "add";
	}
	
	@GetMapping("/products")
	@ResponseBody
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> productList = service.findAllProduct();
		return ResponseEntity.ok(productList);
	}
	
	
	@GetMapping("/product/{id}")
	@ResponseBody
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		Product product = service.findById(id);
		return ResponseEntity.ok(product);
		
	}
	
	@PutMapping("/update")
	@ResponseBody
	public String addProduct(Long id, String name, String descript, String img, Integer price, String category) {
		service.update(id, name, descript, img, price, category);
		return "update";
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteProduct(@PathVariable Long id) {
		service.deleteById(id);
		return "delete";
	}
	
	
	/** ------導頁Controller------ */
	
	@GetMapping(value = {"/"})
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/about")
	public String toAboutPage() {
		return "about";
	}
	
	@GetMapping("/detail/{id}")
	public ModelAndView toDetailPage(@PathVariable Integer id) {
		// 取得指定id的產品資料
		Product product = service.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("detail");
		mav.addObject("product", product);
		return mav;
	}
	
	@GetMapping("/product")
	public ModelAndView toProductPage() {
		List<Product> productList = service.findAllProduct();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("product");
		mav.addObject("products", productList);
		return mav;
	}
	
	@GetMapping("/checkout/{id}/{qty}")
	public ModelAndView toCheckoutPage(@PathVariable Integer id, @PathVariable Integer qty) {
		System.out.println("id: " + id + ",qty: " + qty);
		Product product = service.findById(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("checkout");
		mav.addObject("product", product);
		mav.addObject("qty", qty);
		return mav;
	}
	
	@GetMapping("/confirm")
	public String checkoutConfirm() {
		// 結帳，生成訂單
		
		// PRG
		
		return "checkoutSuccess";
	}
}
