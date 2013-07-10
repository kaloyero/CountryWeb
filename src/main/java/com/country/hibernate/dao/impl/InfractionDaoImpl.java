package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.InfractionDao;
import com.country.hibernate.model.Infraccion;

@Repository("infractionDao")
public class InfractionDaoImpl extends GenericDaoImpl<Infraccion, Integer> implements InfractionDao{

	@Override
	protected Class<Infraccion> getEntityClass() {
		return Infraccion.class;
	}

    public void update(Infraccion infraccion) {
    	  getSession().update(infraccion);
      }

}
