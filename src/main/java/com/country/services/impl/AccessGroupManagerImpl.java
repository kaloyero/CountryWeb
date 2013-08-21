package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.AccessGroupDao;
import com.country.hibernate.model.AccesoGrupo;
import com.country.services.AccessGroupManager;

@Service("accessGroupManager")
public class AccessGroupManagerImpl extends AbstractManagerImpl<AccesoGrupo> implements AccessGroupManager{

	@Autowired
    private AccessGroupDao accessGroupDao;

	protected GenericDao<AccesoGrupo, Integer> getDao() {
		return accessGroupDao;
	}
	
	public AccesoGrupo findById(Integer id) {
		AccesoGrupo dto = accessGroupDao.findById(id);
		return dto;
	}
	
}
