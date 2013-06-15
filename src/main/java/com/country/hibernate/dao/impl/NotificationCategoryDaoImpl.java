package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NotificationCategoryDao;
import com.country.hibernate.model.AvisoCategoria;

@Repository("notificationCategoryDao")
public class NotificationCategoryDaoImpl extends GenericDaoImpl<AvisoCategoria, Integer> implements NotificationCategoryDao{

	@Override
	protected Class<AvisoCategoria> getEntityClass() {
		return AvisoCategoria.class;
	}

}
