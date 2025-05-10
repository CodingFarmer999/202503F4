package com.course.model.session;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.course.model.vo.ProductVo;

/**
 * Session Scope 購物車
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartSession {
	
	private List<ProductVo> productVoList = new ArrayList<>();

	public List<ProductVo> getProductVoList() {
		return productVoList;
	}

	public void setProductVoList(List<ProductVo> productVoList) {
		this.productVoList = productVoList;
	}
	
}
