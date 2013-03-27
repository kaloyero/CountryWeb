package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.RazaDao;
import com.country.hibernate.model.Raza;
import com.country.services.RazaManager;

@Service("razaManager")
public class RazaManagerImpl extends AbstractManagerImpl<Raza> implements RazaManager{

	@Autowired
    private RazaDao razaDao;
	
	protected GenericDao<Raza, Integer> getDao() {
		return razaDao;
	}

	public Raza findById(Integer id) {
		Raza dto = razaDao.findById(id);
		return dto;
	}

}
