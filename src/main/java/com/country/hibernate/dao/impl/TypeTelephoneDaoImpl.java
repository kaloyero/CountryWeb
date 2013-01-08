package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypeTelephoneDao;
import com.country.hibernate.model.TipoTelefono;

@Repository("typeTelephoneDao")
public class TypeTelephoneDaoImpl extends GenericDaoImpl<TipoTelefono, Integer> implements TypeTelephoneDao{

	@Override
	protected Class<TipoTelefono> getEntityClass() {
		return TipoTelefono.class;
	}

}
