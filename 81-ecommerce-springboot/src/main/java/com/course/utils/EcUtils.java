package com.course.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.model.entity.OrderEntity;
import com.course.model.entity.ProductEntity;
import com.course.model.session.CartSession;
import com.course.model.vo.CartVo;
import com.course.model.vo.ProductItem;
import com.course.model.vo.ProductVo;
import com.course.model.vo.ShippingMethod;

@Service
public class EcUtils {
	
	/**
	 * 將 Entity 轉換 成 Vo
	 * @param entity
	 * @return
	 */
	public ProductVo convertToVo(ProductEntity entity) {
		ProductVo vo = new ProductVo();
		vo.setId(entity.getId());
		vo.setCode(entity.getCode());
		vo.setName(entity.getName());
		vo.setListPrice(entity.getListPrice());
		vo.setSalesPrice(entity.getSalesPrice());
		vo.setQuantity(entity.getQuantity());
		vo.setImageUrl("http://localhost:8085/images/" + entity.getImageName());
		return vo;
	}
	
	/**
	 * 將 Entity 轉換 成 Vo
	 * @param entity
	 * @return
	 */
	public CartVo convertToCartVo(CartSession cartSession) {
		CartVo vo = new CartVo();
//		vo.setCode(entity.getCode());
//		vo.setName(entity.getName());
//		vo.setListPrice(entity.getListPrice());
//		vo.setSalesPrice(entity.getSalesPrice());
//		vo.setQuantity(entity.getQuantity());
//		vo.setImageUrl("http://localhost:8080/images/" + entity.getImageName());
		return vo;
	}
	
	public OrderEntity genOrderEntity(CartVo cart, Long userId) {
		OrderEntity order = new OrderEntity();
		
		order.setOrderDate(new Date());
        order.setOrderNo(getOrderNo());
        order.setAmount(cart.getTotalAmount());
        order.setUserId(userId);
        ShippingMethod shippingMethod = cart.getShippingMethod();
        order.setRecipient(shippingMethod.getRecipient());
        order.setAddress(shippingMethod.getAddress());
        order.setPhone(shippingMethod.getPhone());

		
		return order;
	}
	
	/**
	 * 取得訂單編號
	 * YYYYMMDDHHMMSS
	 * @return
	 */
	private String getOrderNo() {
		Date date = new Date();
        // 定義日期格式 YYYYMMDDHHMMSS
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        
        // 將日期格式化為字串
        return formatter.format(date);
	}
}
