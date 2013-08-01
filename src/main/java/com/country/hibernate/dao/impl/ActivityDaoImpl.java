package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.model.Actividad;

@Repository("activityDao")
public class ActivityDaoImpl extends GenericDaoImpl<Actividad, Integer> implements ActivityDao{

	@Override
	protected Class<Actividad> getEntityClass() {
		return Actividad.class;
	}
	
    public void update(Actividad obj) {
    	getSession().update(obj);
    }
	

}
