package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.StateDao;
import com.country.hibernate.model.Ciudad;
import com.country.hibernate.model.Provincia;
import com.country.services.StateManager;

@Service("stateManager")
public class StateManagerImpl implements StateManager{

	@Autowired
    private StateDao stateDao;
	
	public void save(Provincia dto) {
		stateDao.saveOrUpdate(dto);
	}

	public List<Provincia> listAll() {
		List<Provincia> list = new ArrayList<Provincia>();
		list = stateDao.findAll();
		return list;
	}

	public Provincia findById(Integer id) {
		Provincia dto = stateDao.findById(id);
		return dto;
	}
	
	
	/**
	 * @param id de la provincia
	 * @return devuelve la provincia con sus datos y la lista de ciudades 
	 */
	public Provincia getStateCitiesById(Integer id) {
		Provincia dto = stateDao.findById(id);
		dto.getCities();
		return dto;
	}

	/**
	 * @param id de la provincia
	 * @return devuelve la lista de ciudades relacionadas a ese id de Provincia. 
	 */
	public List<Ciudad> getCitiesByIdState(Integer id) {
		Provincia dto = stateDao.findById(id);
		List<Ciudad> list = dto.getCities();
		return list;
	}

}
