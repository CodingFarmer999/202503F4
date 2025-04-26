package com.course.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRICE_SEQ_GENERATOR")
	@SequenceGenerator(name = "PRODUCT_PRICE_SEQ_GENERATOR", sequenceName = "PRODUCT_PRICE_SEQ", allocationSize = 1)
	private Long id;
	
//	@Column
//	private Long productId;
	
	@Column
	private BigDecimal listPrice;
	
	@Column
	private BigDecimal salesPrice;
	
    @OneToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    private ProductEntity product;

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

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	
}
