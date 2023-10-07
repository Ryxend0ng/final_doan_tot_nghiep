package com.ryxenshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ryxenshop.entities.Product;
import com.ryxenshop.entities.ProductImage;

@Repository
public interface ProductImageRepository
		extends JpaRepository<ProductImage, Integer>, JpaSpecificationExecutor<ProductImage> {

	List<ProductImage> findByProduct(Product product);

	List<ProductImage> findByStatus(Boolean status);

	Page<ProductImage> findAll(Specification<ProductImage> spec, Pageable pageable);
}
