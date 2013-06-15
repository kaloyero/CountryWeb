package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.EventDao;
import com.country.hibernate.model.Evento;

@Repository("eventDao")
public class EventDaoImpl extends GenericDaoImpl<Evento, Integer> implements EventDao{

	@Override
	protected Class<Evento> getEntityClass() {
		return Evento.class;
	}

    public void update(Evento obj) {
      	getSession().update(obj);
      }
}
