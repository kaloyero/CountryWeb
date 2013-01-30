package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypeVacunaDao;
import com.country.hibernate.model.TipoVacuna;

@Repository("typeVacunaDao")
public class TypeVacunaDaoImpl extends GenericDaoImpl<TipoVacuna, Integer> implements TypeVacunaDao{

	@Override
	protected Class<TipoVacuna> getEntityClass() {
		return TipoVacuna.class;
	}

}
