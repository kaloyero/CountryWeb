package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NewsSuscriptionDao;
import com.country.hibernate.model.NoticiaSuscripciones;

@Repository("newsSuscriptionDao")
public class NewsSuscriptionDaoImpl extends GenericDaoImpl<NoticiaSuscripciones, Integer> implements NewsSuscriptionDao{

	@Override
	protected Class<NoticiaSuscripciones> getEntityClass() {
		return NoticiaSuscripciones.class;
	}

}
