package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.UnitDao;
import com.country.hibernate.model.Unidad;

@Repository("unitDao")
public class UnitDaoImpl extends GenericDaoImpl<Unidad, Integer> implements UnitDao{

	@Override
	protected Class<Unidad> getEntityClass() {
		return Unidad.class;
	}

}
