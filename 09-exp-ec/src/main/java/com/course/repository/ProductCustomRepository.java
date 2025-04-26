package com.course.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.course.dto.ProductDto;
import com.course.vo.ProductQueryParam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ProductCustomRepository {
	
	// EntityManager
    @PersistenceContext
    private EntityManager entityManager;
    
	/**
	 * 取得所有資料
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public List<ProductDto> findAllProductData() {
    	// !!!!! 這裡的 SQL 只是示例，出來的結果很有問題 !!!!!
    	String sql = """
			SELECT 
			P.NAME,
			R.LIST_PRICE,
			R.SALES_PRICE,
			V.MEMO,
			C.NAME CNAME
			
			FROM PRODUCT P
			JOIN PRODUCT_PRICE R ON r.PRODUCT_ID = P.ID
			LEFT JOIN PRODUCT_REVIEW V ON V.PRODUCT_ID = P.ID
			JOIN PRODUCT_CATEGORY PC ON PC.PRODUCT_ID = P.ID
			JOIN CATEGORY C ON C.ID = PC.CATEGORY_ID
		""";
    	
    	Query query = entityManager.createQuery(sql, ProductDto.class);
    	return query.getResultList();
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
