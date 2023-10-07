package com.ryxenshop.service;

import java.util.List;

import com.ryxenshop.entities.Order;
import com.ryxenshop.entities.OrderDetail;

public interface DetailOrderService {

	public List<OrderDetail> findAllByOrder(Order order) throws Exception;

	public Boolean deleteById(Integer id) throws Exception;

}
