package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ReserveDao;
import com.country.hibernate.model.Reserva;
import com.country.services.ReserveManager;

@Service("reserveManager")
public class ReserveManagerImpl extends AbstractManagerImpl<Reserva> implements ReserveManager{

	@Autowired
    private ReserveDao reserveDao;
	
	protected GenericDao<Reserva, Integer> getDao() {
		return reserveDao;
	}

	public Reserva findById(Integer id) {
		Reserva dto = reserveDao.findById(id);
		return dto;
	}
	
}
