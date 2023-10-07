package com.ryxenshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ryxenshop.entities.Product;
import com.ryxenshop.entities.Review;
import com.ryxenshop.entities.User;
import com.ryxenshop.valueObjects.UserRequestReview;

public interface ReviewService {

	List<Review> findByProduct(Product product) throws Exception;

	public Boolean deleteById(String id) throws Exception;

	Review saveOrUpdate(Review review, User userLogin) throws Exception;

	Page<Review> findAll(UserRequestReview userRequestReview) throws Exception;
	
	Review findById(String id) throws Exception;
}
