package com.ryxenshop.service.impl;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryxenshop.entities.User;
import com.ryxenshop.entities.UserRole;
import com.ryxenshop.exceptions.EntityNotFoundCustomException;
import com.ryxenshop.repository.UserRoleRepository;
import com.ryxenshop.service.UserRoleService;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public Boolean deleteById(Integer id) throws Exception {
		userRoleRepository.deleteById(id);
		return true;
	}

	@Override
	public UserRole saveOrUpdate(UserRole userRole, User userLogin) throws Exception {
		Integer idUserLogin = userLogin != null ? userLogin.getId() : null;
		userRole.setUpdatedBy(idUserLogin);
		userRole.setUpdatedDate(Calendar.getInstance().getTime());
		if (userRole.getId() == null) {
			UserRole oldUserRole = userRoleRepository.findById(idUserLogin)
					.orElseThrow(() -> new EntityNotFoundCustomException("Not found user role"));
			userRole.setCreatedBy(oldUserRole.getCreatedBy());
			userRole.setCreatedDate(oldUserRole.getUpdatedDate());
		}
		return userRoleRepository.save(userRole);
	}

	@Override
	public UserRole findById(Integer id) throws Exception {
		return userRoleRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundCustomException("Not found user role"));
	}

}
