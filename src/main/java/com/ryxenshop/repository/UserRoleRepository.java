package com.ryxenshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ryxenshop.entities.RequestCancelOrder;
import com.ryxenshop.entities.UserRole;

@Repository
public interface UserRoleRepository
		extends JpaRepository<UserRole, Integer>, JpaSpecificationExecutor<RequestCancelOrder> {

	List<UserRole> findByStatus(Boolean status);
}
