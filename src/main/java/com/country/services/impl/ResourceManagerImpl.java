package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ResourceDao;
import com.country.hibernate.model.Recurso;
import com.country.services.ResourceManager;

@Service("resourceManager")
public class ResourceManagerImpl extends AbstractManagerImpl<Recurso> implements ResourceManager{

	@Autowired
    private ResourceDao resourceDao;
	
	protected GenericDao<Recurso, Integer> getDao() {
		return resourceDao;
	}

	public Recurso findById(Integer id) {
		Recurso dto = resourceDao.findById(id);
		return dto;
	}

}
