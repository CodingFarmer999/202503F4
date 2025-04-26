package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.ProductPriceEntity;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {

}
