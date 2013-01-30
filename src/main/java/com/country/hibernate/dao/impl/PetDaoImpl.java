package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.PetDao;
import com.country.hibernate.model.Mascota;

@Repository("petDao")
public class PetDaoImpl extends GenericDaoImpl<Mascota, Integer> implements PetDao{

	@Override
	protected Class<Mascota> getEntityClass() {
		return Mascota.class;
	}

}
