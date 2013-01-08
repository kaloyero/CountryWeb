package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TownDao;
import com.country.hibernate.model.Localidad;

@Repository("townDao")
public class TownDaoImpl extends GenericDaoImpl<Localidad, Integer> implements TownDao{

	@Override
	protected Class<Localidad> getEntityClass() {
		return Localidad.class;
	}

}
