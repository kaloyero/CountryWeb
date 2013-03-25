package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypeResourceDao;
import com.country.hibernate.model.TipoRecurso;
import com.country.services.TypeResourceManager;

@Service("typeResourceManager")
public class TypeResourceManagerImpl extends AbstractManagerImpl<TipoRecurso> implements TypeResourceManager{

	@Autowired
    private TypeResourceDao typeResourceDao;

	protected GenericDao<TipoRecurso, Integer> getDao() {
		return typeResourceDao;
	}

	public TipoRecurso findById(Integer id) {
		TipoRecurso dto = typeResourceDao.findById(id);
		return dto;
	}
	
}
