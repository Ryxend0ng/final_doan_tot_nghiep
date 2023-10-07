package com.ryxenshop.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ryxenshop.entities.Order;
import com.ryxenshop.entities.RequestCancelOrder;
import com.ryxenshop.entities.User;
import com.ryxenshop.valueObjects.UserRequest;

public interface RequestCancelOrderService {

	List<RequestCancelOrder> findAllRequestCancelOrder() throws Exception;

	List<RequestCancelOrder> getUnreadNotify() throws Exception;

	Integer countUnreadNotify() throws Exception;

	RequestCancelOrder saveOrUpdate(RequestCancelOrder requestCancelOrder) throws Exception;

	RequestCancelOrder saveOrUpdate(RequestCancelOrder requestCancelOrder, User userLogin) throws Exception;

	public Boolean deleteById(Integer id) throws Exception;

	List<RequestCancelOrder> findAll() throws Exception;

	RequestCancelOrder findById(String id) throws Exception;

	RequestCancelOrder findByOrder(Order order) throws Exception;

	Boolean deleteById(String idRequest) throws Exception;

	Page<RequestCancelOrder> findByUserRequest(UserRequest userRequest) throws Exception;

}
