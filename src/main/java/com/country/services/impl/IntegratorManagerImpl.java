package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.model.Integrante;
import com.country.services.IntegratorManager;

@Service("integratorManager")
public class IntegratorManagerImpl extends AbstractManagerImpl<Integrante> implements IntegratorManager{

	@Autowired
    private IntegratorDao integratorDao;
	
	protected GenericDao<Integrante, Integer> getDao() {
		return integratorDao;
	}

	@Transactional
	public Integrante findById(Integer id) {
		Integrante dto = integratorDao.findById(id);
		return dto;
	}

	/**
	 * Retorna el Integrante con la lista de Actividades 
	 * a las cuales esta asociado
	 */
	public Integrante getActivitiesById(Integer id) {
		Integrante dto = integratorDao.findById(id);
//		dto.getActivities();
		return dto;
	}
	
}