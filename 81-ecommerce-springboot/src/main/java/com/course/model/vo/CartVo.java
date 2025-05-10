package com.course.model.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartVo {
	
	/** 配送方式 */
	private ShippingMethod shippingMethod;
	
	/** 付款方式 */
	private PaymentMethod paymentMethod;

	/** 購物車總金額 */
	private BigDecimal totalAmount;
	
	/** 商品列表 */
	private List<ProductItem> itemList = new ArrayList<>();

	public List<ProductItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<ProductItem> itemList) {
		this.itemList = itemList;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
