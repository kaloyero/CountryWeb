package com.country.hibernate.dao;

import java.util.List;

import com.country.common.GenericDao;
import com.country.hibernate.model.Vehiculo;

public interface VehicleDao extends GenericDao<Vehiculo, Integer> {
	/**
	 * Devuelve los vehiculos por persona
	 * 
	 * @param integranteId
	 * @return
	 */
	List findVehiclesByUnidad (int unidadId);
	
}
