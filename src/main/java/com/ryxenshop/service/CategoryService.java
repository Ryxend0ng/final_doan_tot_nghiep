package com.ryxenshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.ryxenshop.entities.Category;
import com.ryxenshop.entities.User;
import com.ryxenshop.valueObjects.UserRequest;

public interface CategoryService {

	List<Category> getCategorySlider() throws Exception;

	Page<Category> findAllByUserRequest(UserRequest userRequest) throws Exception;

	Category saveOrUpdate(Category category, MultipartFile avatar, User userLogin) throws Exception;

	Category findBySeo(String seo) throws Exception;

	Boolean deleteById(Integer id) throws Exception;

	List<Category> findByStatus(Boolean status) throws Exception;

	Category findById(Integer id) throws Exception;

	List<Category> findAllByStatus(Boolean status) throws Exception;

}
