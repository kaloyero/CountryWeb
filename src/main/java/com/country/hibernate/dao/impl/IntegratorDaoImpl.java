package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.model.Integrante;

@Repository("integratorDao")
public class IntegratorDaoImpl extends GenericDaoImpl<Integrante, Integer> implements IntegratorDao{

	@Override
	protected Class<Integrante> getEntityClass() {
		return Integrante.class;
	}
	
    public void update(Integrante integrante) {
  	  getSession().update(integrante);
    }


}
