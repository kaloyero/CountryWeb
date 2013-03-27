package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypeAuthorizationDao;
import com.country.hibernate.model.TipoAutorizacion;
import com.country.services.TypeAuthorizationManager;

@Service("typeAuthorizationManager")
public class TypeAuthorizationManagerImpl extends AbstractManagerImpl<TipoAutorizacion> implements TypeAuthorizationManager{

	@Autowired
    private TypeAuthorizationDao typeAuthoriationDao;

	protected GenericDao<TipoAutorizacion, Integer> getDao() {
		return typeAuthoriationDao;
	}
	
	public TipoAutorizacion findById(Integer id) {
		TipoAutorizacion dto = typeAuthoriationDao.findById(id);
		return dto;
	}

}
