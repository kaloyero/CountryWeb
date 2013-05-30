package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.IntegratorActivityDao;
import com.country.hibernate.model.IntegranteActividades;

@Repository("integratorActivityDao")
public class IntegratorActivityDaoImpl extends GenericDaoImpl<IntegranteActividades, Integer> implements IntegratorActivityDao{

	@Override
	protected Class<IntegranteActividades> getEntityClass() {
		return IntegranteActividades.class;
	}
	

}
