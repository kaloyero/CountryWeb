package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypeVacunaDao;
import com.country.hibernate.model.TipoVacuna;
import com.country.services.TypeVacunaManager;

@Service("typeVacunaManager")
public class TypeVacunaManagerImpl extends AbstractManagerImpl<TipoVacuna> implements TypeVacunaManager{

	@Autowired
    private TypeVacunaDao typeVacunaDao;
	
	protected GenericDao<TipoVacuna, Integer> getDao() {
		return typeVacunaDao;
	}
	
	public TipoVacuna findById(Integer id) {
		TipoVacuna dto = typeVacunaDao.findById(id);
		return dto;
	}

}
