package com.ryxenshop.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryxenshop.entities.Introduce;
import com.ryxenshop.entities.User;
import com.ryxenshop.exceptions.EntityNotFoundCustomException;
import com.ryxenshop.repository.IntroduceRepository;
import com.ryxenshop.service.IntroduceService;

@Service
@Transactional
public class IntroduceSeviceImpl implements IntroduceService {

	@Autowired
	private IntroduceRepository introduceRepository;

	@Override
	public Boolean deleteById(Integer id) throws Exception {
		return false;
	}

	@Override
	public Introduce saveOrUpdate(Introduce introduce, User userLogin) throws Exception {
		Integer idUserLogin = userLogin != null ? userLogin.getId() : null;
		if (introduce.getId() != null) {
			Introduce oldIntroduce = introduceRepository.findById(introduce.getId())
					.orElseThrow(() -> new EntityNotFoundCustomException("Not found introduce"));
			introduce.setCreatedBy(oldIntroduce.getCreatedBy());
			introduce.setCreatedDate(oldIntroduce.getCreatedDate());
		} else {
			introduce.setCreatedBy(idUserLogin);
			introduce.setCreatedDate(Calendar.getInstance().getTime());
		}
		introduce.setUpdatedBy(idUserLogin);
		introduce.setUpdatedDate(Calendar.getInstance().getTime());
		return introduceRepository.save(introduce);
	}

	@Override
	public List<Introduce> findAll() throws Exception {
		return introduceRepository.findAll();
	}

	@Override
	public Introduce findById(Integer id) throws Exception {
		return introduceRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundCustomException("Not found introduce"));
	}

}
