package com.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ProductReviewEntity {
	
	private Long id;
	
	private String memo;
	
	private Long productId;
	
	// 與 Product 的關聯(多個評論對應於一個商品) ManyToOne
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
