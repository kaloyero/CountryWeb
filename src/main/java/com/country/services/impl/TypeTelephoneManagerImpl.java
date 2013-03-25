package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypeTelephoneDao;
import com.country.hibernate.model.TipoTelefono;
import com.country.services.TypeTelephoneManager;

@Service("typeTelephoneManager")
public class TypeTelephoneManagerImpl extends AbstractManagerImpl<TipoTelefono> implements TypeTelephoneManager{

	@Autowired
    private TypeTelephoneDao typeTelephoneDao;
	
	protected GenericDao<TipoTelefono, Integer> getDao() {
		return typeTelephoneDao;
	}

	public TipoTelefono findById(Integer id) {
		TipoTelefono dto = typeTelephoneDao.findById(id);
		return dto;
	}

}
