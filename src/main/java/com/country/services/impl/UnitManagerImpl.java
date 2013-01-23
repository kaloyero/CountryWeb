package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.UnitDao;
import com.country.hibernate.model.Unidad;
import com.country.services.UnitManager;

@Service("unitManager")
public class UnitManagerImpl extends AbstractManagerImpl<Unidad> implements UnitManager{

	@Autowired
    private UnitDao unitDao;
	
	protected GenericDao<Unidad, Integer> getDao() {
		return unitDao;
	}

	public Unidad findById(Integer id) {
		Unidad dto = unitDao.findById(id);
		return dto;
	}
	
}
