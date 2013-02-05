package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.VisitorDao;
import com.country.hibernate.model.Autorizado;

@Repository("visitorDao")
public class VisitorDaoImpl extends GenericDaoImpl<Autorizado, Integer> implements VisitorDao{

	@Override
	protected Class<Autorizado> getEntityClass() {
		return Autorizado.class;
	}

}
