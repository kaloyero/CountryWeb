package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TelephoneDao;
import com.country.hibernate.model.Telefono;

@Repository("telephoneDao")
public class TelephoneDaoImpl extends GenericDaoImpl<Telefono, Integer> implements TelephoneDao{

	@Override
	protected Class<Telefono> getEntityClass() {
		return Telefono.class;
	}

    public void update(Telefono obj) {
    	  getSession().update(obj);
    }

}
