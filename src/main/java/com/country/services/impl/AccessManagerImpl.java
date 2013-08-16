package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.AccessDao;
import com.country.hibernate.model.Acceso;
import com.country.services.AccessManager;

@Service("accessManager")
public class AccessManagerImpl extends AbstractManagerImpl<Acceso> implements AccessManager{

	@Autowired
    private AccessDao accessDao;

	protected GenericDao<Acceso, Integer> getDao() {
		return accessDao;
	}
	
	public Acceso findById(Integer id) {
		Acceso dto = accessDao.findById(id);
		return dto;
	}
	
}
