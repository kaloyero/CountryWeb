package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.PaymentDao;
import com.country.hibernate.model.Pago;
import com.country.services.PaymentManager;

@Service("paymentManager")
public class PaymentManagerImpl extends AbstractManagerImpl<Pago> implements PaymentManager{

	@Autowired
    private PaymentDao paymentDao;

	protected GenericDao<Pago, Integer> getDao() {
		return paymentDao;
	}
	
	public Pago findById(Integer id) {
		Pago dto = paymentDao.findById(id);
		return dto;
	}
	
	@Transactional
	public void save(Pago dto) {
		
		//TODO
		
	}
	
	@Transactional
	public void update(Pago dto) {
		
		//TODO

	}
	
}
