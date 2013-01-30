package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypeInfractionDao;
import com.country.hibernate.model.TipoInfraccion;

@Repository("typeInfractionDao")
public class TypeInfractionDaoImpl extends GenericDaoImpl<TipoInfraccion, Integer> implements TypeInfractionDao{

	@Override
	protected Class<TipoInfraccion> getEntityClass() {
		return TipoInfraccion.class;
	}

}
