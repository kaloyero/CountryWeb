package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypeInfractionDao;
import com.country.hibernate.model.TipoInfraccion;
import com.country.services.TypeInfractionManager;

@Service("typeInfractionManager")
public class TypeInfractionManagerImpl extends AbstractManagerImpl<TipoInfraccion> implements TypeInfractionManager{

	@Autowired
    private TypeInfractionDao typeInfractionDao;
	
	protected GenericDao<TipoInfraccion, Integer> getDao() {
		return typeInfractionDao;
	}
	
}
