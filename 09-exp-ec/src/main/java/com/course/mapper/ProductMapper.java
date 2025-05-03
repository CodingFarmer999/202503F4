package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.course.dto.ProductDto;

@Mapper
public interface ProductMapper {

	@Select("SELECT * FROM PRODUCT P LEFT JOIN PRODUCT_PRICE R ON R.PRODUCT_ID = P.ID")
	List<ProductDto> findAll();
	
	@Select("SELECT * FROM　PRODUCT_REVIEW RE WHERE RE.PRODUCT_ID = #{id}")
	List<ProductDto> findReviewById(Long id);
}
