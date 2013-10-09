package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.VehicleDao;
import com.country.hibernate.model.Vehiculo;
import com.country.services.VehicleManager;

@Service("vehicleManager")
public class VehicleManagerImpl extends AbstractManagerImpl<Vehiculo> implements VehicleManager{

	@Autowired
    private VehicleDao vehicleDao;
	
	protected GenericDao<Vehiculo, Integer> getDao() {
		return vehicleDao;
	}

	public Vehiculo findById(Integer id) {
		Vehiculo dto = vehicleDao.findById(id);
		return dto;
	}
	public List<Vehiculo> findVehicleByUnidad(Integer unidadId) {
		List<Vehiculo> dto = vehicleDao.findVehiclesByUnidad(unidadId);
		return dto;
	}
	
}
