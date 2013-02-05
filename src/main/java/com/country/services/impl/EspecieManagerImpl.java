package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.EspecieDao;
import com.country.hibernate.model.Especie;
import com.country.services.EspecieManager;

@Service("especieManager")
public class EspecieManagerImpl extends AbstractManagerImpl<Especie> implements EspecieManager{

	@Autowired
    private EspecieDao especieDao;
	
	protected GenericDao<Especie, Integer> getDao() {
		return especieDao;
	}
	
}
