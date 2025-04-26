package com.course.entity;

public class CategoryEntity {

	private Long id;
	
	private String name;
	
	// 與 Product 的關聯(一個商品可以有多個分類、一個分類也會有多個商品) ManyToMany

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
