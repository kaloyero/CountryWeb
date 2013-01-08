package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.StateDao;
import com.country.hibernate.model.Provincia;

@Repository("stateDao")
public class StateDaoImpl extends GenericDaoImpl<Provincia, Integer> implements StateDao{

	@Override
	protected Class<Provincia> getEntityClass() {
		return Provincia.class;
	}

}
