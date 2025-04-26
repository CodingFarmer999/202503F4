package com.course.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GENERATOR")
	@SequenceGenerator(name = "PRODUCT_SEQ_GENERATOR", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
	private Long id;
	
	@Column
	private String code;
	
	@Column
	private String name;
	
	// 與 Product Price 的關聯 OneToOne
	
    // ProductPriceEntity 的 ProductEntity 欄位名稱
    @OneToOne(mappedBy = "product",  cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductPriceEntity productPrice;
	
	
	// 與 Product Review 的關聯(一個商品可以有多個評論) OneToMany

	
	// 與 Product Category 的關聯(一個商品可以有多個分類、一個分類也會有多個商品) ManyToMany
	// iPhone -> 3C, 手機 , 3C -> iPhone, 平板
      
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
