package com.course.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.course.dao.ProductDao;
import com.course.dao.ProductRowMapper;
import com.course.entity.Product;

@Repository
public class ProductJdbcDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	// 新增
	@Override
	public Integer addProduct(String name, String descript, String img, Integer price, String category) {
		String sql = "insert into product (name, descript, img, price, category) values(?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, name, descript, img , price, category);
	}

	// 查詢
	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM product";
		// return jdbcTemplate.query(sql, new ProductRowMapper());
		return jdbcTemplate.query(sql, new RowMapper<Product>() {
			// 匿名類別
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
		});
	}

	// 查詢
	@Override
	public Product findById(Integer id) {
		String sql = "SELECT * FROM product where id = ?";
		Product product = null;
		try {
			product = jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
		} catch (EmptyResultDataAccessException e) {
			// 找不到資料，需要try catch EmptyResultDataAccessException
		}

		return product;
	}

	// 更新
	@Override
	public Integer update(Long id, String name, String descript, String img, Integer price, String category) {
		String sql = "update product set name = ?, descript = ?, img = ?, price = ?, category = ? where id = ?";
		return jdbcTemplate.update(sql, name, descript, img, price, category, id);
	}

	// 刪除
	@Override
	public Integer delete(Long id) {
		String sql = "delete from product where id = ?";
		return jdbcTemplate.update(sql, id);
	}


}
