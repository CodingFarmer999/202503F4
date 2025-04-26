package com.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT_REVIEW")
public class ProductReviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_REVIEW_SEQ_GENERATOR")
	@SequenceGenerator(name = "PRODUCT_REVIEW_SEQ_GENERATOR", sequenceName = "PRODUCT_REVIEW_SEQ", allocationSize = 1)
	private Long id;
	
	@Column
	private String memo;
	
//	@Column
//	private Long productId;
	
	// 與 Product 的關聯(多個評論對應於一個商品) ManyToOne
	@ManyToOne()
	@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private ProductEntity product;

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
