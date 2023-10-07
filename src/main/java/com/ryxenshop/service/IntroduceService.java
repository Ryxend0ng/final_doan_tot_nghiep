package com.ryxenshop.service;

import java.util.List;

import com.ryxenshop.entities.Introduce;
import com.ryxenshop.entities.User;

public interface IntroduceService {

	List<Introduce> findAll() throws Exception;

	Boolean deleteById(Integer id) throws Exception;

	Introduce saveOrUpdate(Introduce introduce, User userLogin) throws Exception;

	Introduce findById(Integer id) throws Exception;

}
