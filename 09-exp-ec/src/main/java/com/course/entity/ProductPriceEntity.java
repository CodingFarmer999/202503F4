package com.course.entity;

import java.math.BigDecimal;

public class ProductPriceEntity {

	private Long id;
	
	private BigDecimal listPrice;
	
	private BigDecimal salesPrice;

	private Long productId;
	
	// 與 Product 的關聯 OneToOne
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Long productId) {
//		this.productId = productId;
//	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}
	
}
