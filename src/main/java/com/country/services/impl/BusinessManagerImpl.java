package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.BusinessDao;
import com.country.hibernate.model.Emprendimiento;
import com.country.services.BusinessManager;

@Service("businessManager")
public class BusinessManagerImpl implements BusinessManager{

	@Autowired
    private BusinessDao businessDao;
	
	public void save(Emprendimiento dto) {
		businessDao.saveOrUpdate(dto);
	}

	public List<Emprendimiento> listAll() {
		List<Emprendimiento> list = new ArrayList<Emprendimiento>();
		list = businessDao.findAll();
		return list;
	}

	public Emprendimiento findById(Integer id) {
		Emprendimiento dto = businessDao.findById(id);
		dto.getUnits();
		return dto;
	}
	
}
