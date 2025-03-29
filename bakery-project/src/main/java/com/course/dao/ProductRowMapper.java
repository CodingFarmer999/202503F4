package com.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.course.entity.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setDescript(rs.getString("descript"));
        product.setImg(rs.getString("img"));
        product.setPrice(rs.getInt("price"));
        product.setCategory(rs.getString("category"));
		return product;
	}

}
