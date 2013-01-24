package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TownDao;
import com.country.hibernate.model.Localidad;
import com.country.services.TownManager;

@Service("townManager")
public class TownManagerImpl extends AbstractManagerImpl<Localidad> implements TownManager{

	@Autowired
    private TownDao townDao;

	protected GenericDao<Localidad, Integer> getDao() {
		return townDao;
	}

	
	public Localidad findById(Integer id) {
		Localidad dto = townDao.findById(id);
		return dto;
	}
	
}
