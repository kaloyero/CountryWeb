package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.PeriodDao;
import com.country.hibernate.model.Periodo;

@Repository("periodDao")
public class PeriodDaoImpl extends GenericDaoImpl<Periodo, Integer> implements PeriodDao{

	@Override
	protected Class<Periodo> getEntityClass() {
		return Periodo.class;
	}

}
