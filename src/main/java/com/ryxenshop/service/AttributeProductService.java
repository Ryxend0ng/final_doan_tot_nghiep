package com.ryxenshop.service;

import java.util.List;

import com.ryxenshop.entities.AttributeProduct;
import com.ryxenshop.entities.Product;
import com.ryxenshop.entities.User;

public interface AttributeProductService {

	public List<AttributeProduct> findAllByProduct(Product product) throws Exception;

	public Boolean deleteById(Integer id) throws Exception;

	AttributeProduct findById(Integer id) throws Exception;

	AttributeProduct saveOrUpdate(AttributeProduct attributeProduct, User userLogin) throws Exception;

}
