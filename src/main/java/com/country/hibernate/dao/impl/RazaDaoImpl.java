package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.RazaDao;
import com.country.hibernate.model.Raza;

@Repository("razaDao")
public class RazaDaoImpl extends GenericDaoImpl<Raza, Integer> implements RazaDao{

	@Override
	protected Class<Raza> getEntityClass() {
		return Raza.class;
	}

}
