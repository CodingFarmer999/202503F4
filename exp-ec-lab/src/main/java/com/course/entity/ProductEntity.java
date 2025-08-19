package com.course.entity;

public class ProductEntity {

	// 與 Product Price 的關聯 OneToOne
	
	
	// 與 Product Review 的關聯(一個商品可以有多個評論) OneToMany
	
	
	// 與 Product Category 的關聯(一個商品可以有多個分類、一個分類也會有多個商品) ManyToMany
	// iPhone -> 3C, 手機 , 3C -> iPhone, 平板
}
