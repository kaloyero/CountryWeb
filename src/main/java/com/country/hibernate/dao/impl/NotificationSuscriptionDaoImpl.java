package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NotificationSuscriptionDao;
import com.country.hibernate.model.AvisoSuscripcion;

@Repository("notificationSuscriptionDao")
public class NotificationSuscriptionDaoImpl extends GenericDaoImpl<AvisoSuscripcion, Integer> implements NotificationSuscriptionDao{

	@Override
	protected Class<AvisoSuscripcion> getEntityClass() {
		return AvisoSuscripcion.class;
	}
	
}
