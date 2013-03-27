package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypePaymentDao;
import com.country.hibernate.model.TipoPagos;
import com.country.services.TypePaymentManager;

@Service("typePaymentManager")
public class TypePaymentManagerImpl extends AbstractManagerImpl<TipoPagos> implements TypePaymentManager{

	@Autowired
    private TypePaymentDao typePaymentDao;

	protected GenericDao<TipoPagos, Integer> getDao() {
		return typePaymentDao;
	}

	public TipoPagos findById(Integer id) {
		TipoPagos dto = typePaymentDao.findById(id);
		return dto;
	}
	
}
