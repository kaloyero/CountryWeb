package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.AccessDao;
import com.country.hibernate.model.Acceso;

@Repository("accessDao")
public class AccessDaoImpl extends GenericDaoImpl<Acceso, Integer> implements AccessDao{

	@Override
	protected Class<Acceso> getEntityClass() {
		return Acceso.class;
	}

    public void update(Acceso obj) {
      	getSession().update(obj);
    }
}
