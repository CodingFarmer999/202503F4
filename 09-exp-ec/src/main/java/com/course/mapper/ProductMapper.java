package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.course.dto.ProductDto;
import com.course.vo.ProductQueryParam;
import com.course.vo.ProductVo;

// @Mapper
public interface ProductMapper {

	@Select("SELECT * FROM PRODUCT P LEFT JOIN PRODUCT_PRICE R ON R.PRODUCT_ID = P.ID")
	List<ProductDto> findAll();
	
	@Select("SELECT * FROM PRODUCT_REVIEW RE WHERE RE.PRODUCT_ID = #{id}")
	List<ProductDto> findReviewById(Long id);
	
	@Select("SELECT * FROM PRODUCT_REVIEW")
	List<ProductDto> findAllReview();
	
	@Select("SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL")
	Long getProductSeq();
	
	@Insert("INSERT INTO PRODUCT (ID, CODE, NAME) VALUES (#{id}, #{code}, #{name})")
	void insertProduct(ProductVo vo);
	
	@Insert("INSERT INTO PRODUCT_PRICE (ID, PRODUCT_ID, LIST_PRICE, SALES_PRICE) VALUES (PRODUCT_PRICE_SEQ.NEXTVAL, #{id}, #{listPrice}, #{salesPrice})")
	void insertProductPrice(ProductVo vo);
	
	ProductDto findById(Long id);
	
	List<ProductDto> findByCondition(ProductQueryParam queryParam);
	
	List<ProductDto> findByCategories(List<String> categories);
	
	void updatePrice(ProductVo vo);
}
