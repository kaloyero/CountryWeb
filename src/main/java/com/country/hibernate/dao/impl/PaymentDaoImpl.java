package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.PaymentDao;
import com.country.hibernate.model.Pago;

@Repository("paymentDao")
public class PaymentDaoImpl extends GenericDaoImpl<Pago, Integer> implements PaymentDao{

	@Override
	protected Class<Pago> getEntityClass() {
		return Pago.class;
	}

    public void update(Pago pago) {
    	  getSession().update(pago);
    }

}
