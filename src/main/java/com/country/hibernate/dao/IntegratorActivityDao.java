package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.IntegranteActividades;

public interface IntegratorActivityDao extends GenericDao<IntegranteActividades, Integer> {

	IntegranteActividades findByActivityUser (int activityId, int userId);
	
}
