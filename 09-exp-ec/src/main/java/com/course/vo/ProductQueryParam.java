package com.course.vo;

import java.math.BigDecimal;

/**
 * 產品查詢條件 VO物件
 */
public class ProductQueryParam {

	/** 商品名稱 */
	private String productName;
	
	/** 搜尋金額下限 */
	private BigDecimal minPrice;
	
	/** 搜尋金額上限 */
	private BigDecimal maxPrice;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}
	
}
