package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypeResourceDao;
import com.country.hibernate.model.TipoRecurso;

@Repository("typeResourceDao")
public class TypeResourceDaoImpl extends GenericDaoImpl<TipoRecurso, Integer> implements TypeResourceDao{

	@Override
	protected Class<TipoRecurso> getEntityClass() {
		return TipoRecurso.class;
	}

}
