package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.CityDao;
import com.country.hibernate.model.Ciudad;

@Repository("cityDao")
public class CityDaoImpl extends GenericDaoImpl<Ciudad, Integer> implements CityDao{

	@Override
	protected Class<Ciudad> getEntityClass() {
		return Ciudad.class;
	}

}
