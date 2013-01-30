package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypeAuthorizationDao;
import com.country.hibernate.model.TipoAutorizacion;

@Repository("typeAuthorizationDao")
public class TypeAuthorizationDaoImpl extends GenericDaoImpl<TipoAutorizacion, Integer> implements TypeAuthorizationDao{

	@Override
	protected Class<TipoAutorizacion> getEntityClass() {
		return TipoAutorizacion.class;
	}

}
