package com.country.hibernate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypePaymentDao;
import com.country.hibernate.model.TipoPagos;

@Repository("typePaymentDao")
public class TypePaymentDaoImpl extends GenericDaoImpl<TipoPagos, Integer> implements TypePaymentDao{

	@Override
	protected Class<TipoPagos> getEntityClass() {
		return TipoPagos.class;
	}

	public void saveList(List<TipoPagos> list) {
		for (TipoPagos tipoPagos: list) {
			save(tipoPagos);
		}
	}
	
}
