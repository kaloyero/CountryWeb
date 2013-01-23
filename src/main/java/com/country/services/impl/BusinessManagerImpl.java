package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.BusinessDao;
import com.country.hibernate.model.Emprendimiento;
import com.country.services.BusinessManager;

@Service("businessManager")
public class BusinessManagerImpl extends AbstractManagerImpl<Emprendimiento> implements BusinessManager{

	@Autowired
    private BusinessDao businessDao;
	
	protected GenericDao<Emprendimiento, Integer> getDao() {
		return businessDao;
	}

	
	public Emprendimiento findById(Integer id) {
		Emprendimiento dto = businessDao.findById(id);
		dto.getUnits();
		return dto;
	}
	
}
