package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.model.Integrante;
import com.country.services.IntegratorManager;

@Service("integratorManager")
public class IntegratorManagerImpl implements IntegratorManager{

	@Autowired
    private IntegratorDao integratorDao;
	
	public void save(Integrante dto) {
		integratorDao.saveOrUpdate(dto);
	}

	public List<Integrante> listAll() {
		List<Integrante> list = new ArrayList<Integrante>();
		list = integratorDao.findAll();
		return list;
	}

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
		dto.getActivities();
		return dto;
	}
	
}