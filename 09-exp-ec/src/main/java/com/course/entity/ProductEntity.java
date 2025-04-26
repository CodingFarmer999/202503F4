package com.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ProductEntity {

	@Id
	private Long id;
	
	@Column
	private String code;
	
	@Column
	private String name;
	
	// 與 Product Price 的關聯 OneToOne
	
	
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
