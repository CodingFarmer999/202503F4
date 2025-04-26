package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.entity.ProductPriceEntity;

public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {

}
