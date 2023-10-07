package com.ryxenshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ryxenshop.entities.Product;
import com.ryxenshop.entities.User;
import com.ryxenshop.valueObjects.CategoryQuantityProduct;
import com.ryxenshop.valueObjects.UserRequestToProduct;

public interface ProductService {

	List<Product> findTop8NewProduct() throws Exception;

	List<Product> findTop8ProductHot() throws Exception;

	Product saveOrUpdate(Product product, MultipartFile avatar, MultipartFile[] images, User userLogin)
			throws Exception;

	Product saveOrUpdate(Product product, User userLogin) throws Exception;

	Page<Product> findByUserRequestToProduct(UserRequestToProduct request) throws Exception;

	Product findBySeo(String seo) throws Exception;

	Boolean deleteById(String idProduct) throws Exception;

	List<Product> findByStatus(Boolean status) throws Exception;

	Product findById(Integer id) throws Exception;

	Long getTotalProduct() throws Exception;

	List<CategoryQuantityProduct> getTotalByCategory() throws Exception;
}
