package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.CityDao;
import com.country.hibernate.model.Ciudad;
import com.country.hibernate.model.Localidad;
import com.country.services.CityManager;

@Service("cityManager")
public class CityManagerImpl extends AbstractManagerImpl<Ciudad> implements CityManager{

	@Autowired
    private CityDao cityDao;

	protected GenericDao<Ciudad, Integer> getDao() {
		return cityDao;
	}

	
	public Ciudad findById(Integer id) {
		Ciudad dto = cityDao.findById(id);
		return dto;
	}
	
	/**
	 * @param id de la ciudad
	 * @return devuelve la ciudad con sus datos y la lista de Localidades 
	 */
	public Ciudad getCityTownsById(Integer id) {
		Ciudad dto = cityDao.findById(id);
		dto.getTowns();
		return dto;
	}

	/**
	 * @param id de la ciudad
	 * @return devuelve la lista de Localidades relacionadas a ese id de ciudad. 
	 */
	@Transactional
	public List<Localidad> getTownsByIdCity(Integer id) {
		Ciudad dto = cityDao.findById(id);
		List<Localidad> list = dto.getTowns();
		list.size();
		return list;
	}
	
}
