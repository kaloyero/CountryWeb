package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NotificationDao;
import com.country.hibernate.model.Aviso;

@Repository("notificationDao")
public class NotificationDaoImpl extends GenericDaoImpl<Aviso, Integer> implements NotificationDao{

	@Override
	protected Class<Aviso> getEntityClass() {
		return Aviso.class;
	}

}
