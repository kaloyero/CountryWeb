package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.BusinessDao;
import com.country.hibernate.model.Emprendimiento;

@Repository("businessDao")
public class BusinessDaoImpl extends GenericDaoImpl<Emprendimiento, Integer> implements BusinessDao{

	@Override
	protected Class<Emprendimiento> getEntityClass() {
		return Emprendimiento.class;
	}

}
