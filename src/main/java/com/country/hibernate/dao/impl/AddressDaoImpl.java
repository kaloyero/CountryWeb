package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.AddressDao;
import com.country.hibernate.model.Direccion;

@Repository("addressDao")
public class AddressDaoImpl extends GenericDaoImpl<Direccion, Integer> implements AddressDao{

	@Override
	protected Class<Direccion> getEntityClass() {
		return Direccion.class;
	}

    public void update(Direccion obj) {
    	  getSession().update(obj);
    }

}
