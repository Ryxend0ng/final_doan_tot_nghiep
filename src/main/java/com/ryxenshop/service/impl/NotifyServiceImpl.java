package com.ryxenshop.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryxenshop.repository.NotifyRepository;
import com.ryxenshop.service.NotifyService;
import com.ryxenshop.utils.Validate;

@Service
@Transactional
public class NotifyServiceImpl implements NotifyService {

	@Autowired
	private NotifyRepository notifyRepository;

	@Override
	public Boolean deleteById(String id) throws Exception {
		if (!Validate.isNumber(id)) {
			return false;
		}
		notifyRepository.deleteById(Integer.parseInt(id));
		return true;
	}

}
