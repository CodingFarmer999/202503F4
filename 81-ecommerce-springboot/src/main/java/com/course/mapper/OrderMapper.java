package com.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.course.model.vo.OrderVo;

@Mapper
public interface OrderMapper {
	
	List<OrderVo> findByUserId(Long userId);

}
