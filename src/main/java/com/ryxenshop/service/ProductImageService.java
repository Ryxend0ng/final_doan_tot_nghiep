package com.ryxenshop.service;

import java.util.List;

import com.ryxenshop.entities.Product;
import com.ryxenshop.entities.ProductImage;

public interface ProductImageService {

	List<ProductImage> findByProduct(Product product);

	public Boolean deleteById(Integer id) throws Exception;

}
