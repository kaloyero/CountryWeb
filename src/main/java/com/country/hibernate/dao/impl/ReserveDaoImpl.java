package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ReserveDao;
import com.country.hibernate.model.Reserva;

@Repository("reserveDao")
public class ReserveDaoImpl extends GenericDaoImpl<Reserva, Integer> implements ReserveDao{

	@Override
	protected Class<Reserva> getEntityClass() {
		return Reserva.class;
	}

}
