package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ResourceAvaiableDao;
import com.country.hibernate.model.RecursoDisponibilidad;
import com.country.services.ResourceAvaiableManager;

@Service("resourceAvaiableManager")
public class ResourceAvaiableManagerImpl extends AbstractManagerImpl<RecursoDisponibilidad> implements ResourceAvaiableManager{

	@Autowired
    private ResourceAvaiableDao resourceAvaiableDao;
	
	protected GenericDao<RecursoDisponibilidad, Integer> getDao() {
		return resourceAvaiableDao;
	}
	
	@Transactional
	public List<RecursoDisponibilidad> findResourcesAvaiableById(Integer id) {
		List<RecursoDisponibilidad> list = resourceAvaiableDao.findAllByProperty("recurso", id);
		return list;
	}

	@Transactional
	public List<RecursoDisponibilidad> findResourcesAvaiableByDayOfWeek(Integer resource,int dayOfweek) {
	
		
		List<RecursoDisponibilidad> list = resourceAvaiableDao.listDisponibilidadRecursoPorDia(resource, dayOfweek);
		return list;
	}
	
	
	
	
}
