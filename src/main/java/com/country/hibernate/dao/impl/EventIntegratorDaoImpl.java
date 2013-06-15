package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.EventIntegratorDao;
import com.country.hibernate.model.EventoIntegrante;

@Repository("eventIntegratorDao")
public class EventIntegratorDaoImpl extends GenericDaoImpl<EventoIntegrante, Integer> implements EventIntegratorDao{

	@Override
	protected Class<EventoIntegrante> getEntityClass() {
		return EventoIntegrante.class;
	}

}
