package com.course.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.course.dto.ProductDto;
import com.course.vo.ProductQueryParam;

public class ProductCustomRepository {
	
	// EntityManager
    
	/**
	 * 取得所有資料
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public List<ProductDto> findAllProductData() {

    	return null;
    }
    
    /**
     * 依條件查詢
     * @param queryParam
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<ProductDto> findByCondition(ProductQueryParam queryParam) {

    	return null;
    }

}
