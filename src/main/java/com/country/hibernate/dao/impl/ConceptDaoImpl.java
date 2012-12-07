package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ConceptDao;
import com.country.hibernate.model.Concepto;

@Repository("conceptDao")
public class ConceptDaoImpl extends GenericDaoImpl<Concepto, Integer> implements ConceptDao{

	@Override
	protected Class<Concepto> getEntityClass() {
		return Concepto.class;
	}

}
