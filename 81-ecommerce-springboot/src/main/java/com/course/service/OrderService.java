package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.mapper.OrderMapper;
import com.course.model.entity.OrderEntity;
import com.course.model.vo.OrderVo;
import com.course.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderMapper orderMapper;
	
	public List<OrderVo> getUserOrder(Long userId) {
		List<OrderVo> orderList = orderMapper.findByUserId(userId);
		return orderList;
	}
	
	public List<OrderEntity> getUserOrder2(Long userId) {
		List<OrderEntity> orderEntityList = orderRepo.findByUserId(userId);
		return orderEntityList;
	}
}
