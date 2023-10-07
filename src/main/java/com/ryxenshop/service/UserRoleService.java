package com.ryxenshop.service;

import com.ryxenshop.entities.User;
import com.ryxenshop.entities.UserRole;

public interface UserRoleService {

	UserRole saveOrUpdate(UserRole userRole, User userLogin) throws Exception;

	Boolean deleteById(Integer id) throws Exception;

	UserRole findById(Integer id) throws Exception;

}
