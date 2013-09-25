package com.country.hibernate.dao;

import java.util.Collection;

import com.country.common.GenericDao;
import com.country.hibernate.model.Actividad;

public interface ActivityDao extends GenericDao<Actividad, Integer> {

	Collection<Integer> getActividadVigentes();
}
