package com.course.vo;

import java.math.BigDecimal;
import java.util.List;

public class ProductVo {

	private String code;
	
	private String name;
	
	private BigDecimal listPrice;
	
	private BigDecimal salesPrice;
	
	private List<String> memos;
	
	private List<String> categories;

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

	public List<String> getMemos() {
		return memos;
	}

	public void setMemos(List<String> memos) {
		this.memos = memos;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}


}
