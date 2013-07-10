package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ConceptUnitDao;
import com.country.hibernate.model.UnidadConcepto;

@Repository("conceptUnitDao")
public class ConceptUnitDaoImpl extends GenericDaoImpl<UnidadConcepto, Integer> implements ConceptUnitDao{

	@Override
	protected Class<UnidadConcepto> getEntityClass() {
		return UnidadConcepto.class;
	}

    public void update(UnidadConcepto obj) {
      	getSession().update(obj);
      }
}
