package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ResourceAvaiableDao;
import com.country.hibernate.model.RecursoDisponibilidad;

@Repository("resourceAvaiableDao")
public class ResourceAvaiableDaoImpl extends GenericDaoImpl<RecursoDisponibilidad, Integer> implements ResourceAvaiableDao{

	@Override
	protected Class<RecursoDisponibilidad> getEntityClass() {
		return RecursoDisponibilidad.class;
	}

}
