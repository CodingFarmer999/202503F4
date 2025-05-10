package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.vo.OrderVo;
import com.course.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{userId}")
	public List<OrderVo> getOrdersByUser(@PathVariable Long userId) {
		return orderService.getUserOrder(userId);
	}
}
