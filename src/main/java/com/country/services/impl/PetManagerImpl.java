package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.PetDao;
import com.country.hibernate.model.Mascota;
import com.country.hibernate.model.Vehiculo;
import com.country.services.PetManager;

@Service("petManager")
public class PetManagerImpl extends AbstractManagerImpl<Mascota> implements PetManager{

	@Autowired
    private PetDao petDao;
	
	protected GenericDao<Mascota, Integer> getDao() {
		return petDao;
	}

	public Mascota findById(Integer id) {
		Mascota dto = petDao.findById(id);
		return dto;
	}
	@Transactional
	public List findByMascotasByUnidad(Integer unidadId) {
		List<Mascota> dto = petDao.findMascotassByUnidad(unidadId);
		return dto;
	}

}
