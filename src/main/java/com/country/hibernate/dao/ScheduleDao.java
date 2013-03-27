package com.country.hibernate.dao;

import java.util.List;

import com.country.common.GenericDao;
import com.country.hibernate.model.Cronograma;

public interface ScheduleDao extends GenericDao<Cronograma, Integer> {

	void saveList(List<Cronograma> list);
	
}
