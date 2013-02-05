package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.EspecieDao;
import com.country.hibernate.model.Especie;

@Repository("especieDao")
public class EspecieDaoImpl extends GenericDaoImpl<Especie, Integer> implements EspecieDao{

	@Override
	protected Class<Especie> getEntityClass() {
		return Especie.class;
	}

}
