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
	
    @PersistenceContext
    private EntityManager entityManager;
    
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
    	
//    	Query query = entityManager.createNativeQuery(sql, ProductDto.class);
    	Query query = entityManager.createNativeQuery(sql, "ProductDtoMapping");
    	
    	return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<ProductDto> findByCondition(ProductQueryParam queryParam) {
    	
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT ");
    	sql.append("P.CODE, ");
    	sql.append("P.NAME, ");
    	sql.append("R.LIST_PRICE, ");
    	sql.append("R.SALES_PRICE ");
    	sql.append("FROM PRODUCT P ");
    	sql.append("JOIN PRODUCT_PRICE R ON R.PRODUCT_ID = P.ID ");
    	
    	// 固定為 true 的條件
    	sql.append("WHERE P.ID IS NOT NULL ");
 
    	if (queryParam.getProductName() != null && !queryParam.getProductName().isBlank()) {
    		sql.append("AND P.NAME LIKE :PRODUCTNAME ");
    	}
    	
    	if (queryParam.getMinPrice() != null) {
    		sql.append("AND R.SALES_PRICE >= :MINPRICE ");
    	}
    	
    	if (queryParam.getMaxPrice() != null) {
    		sql.append("AND R.SALES_PRICE <= :MAXPRICE ");
    	}
    	
    	Query query = entityManager.createNativeQuery(sql.toString(),  ProductDto.class);
    	
    	if (queryParam.getProductName() != null && !queryParam.getProductName().isBlank()) {
    		query.setParameter("PRODUCTNAME", "%" + queryParam.getProductName() + "%");
    	}
    	
    	if (queryParam.getMinPrice() != null) {
    		query.setParameter("MINPRICE", queryParam.getMinPrice());
    	}
    	
    	if (queryParam.getMaxPrice() != null) {
    		query.setParameter("MAXPRICE", queryParam.getMaxPrice());
    	}
    	
    	return query.getResultList();
    }

}
