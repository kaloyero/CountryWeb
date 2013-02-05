package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ResourceDao;
import com.country.hibernate.model.Recurso;

@Repository("resourceDao")
public class ResourceDaoImpl extends GenericDaoImpl<Recurso, Integer> implements ResourceDao{

	@Override
	protected Class<Recurso> getEntityClass() {
		return Recurso.class;
	}

}
