package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ScheduleDao;
import com.country.hibernate.model.Cronograma;

@Repository("scheduleDao")
public class ScheduleDaoImpl extends GenericDaoImpl<Cronograma, Integer> implements ScheduleDao{

	@Override
	protected Class<Cronograma> getEntityClass() {
		return Cronograma.class;
	}

}
