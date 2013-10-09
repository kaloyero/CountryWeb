package com.country.services;

import java.util.List;

import com.country.hibernate.model.Vehiculo;

public interface VehicleManager extends AbstractManager<Vehiculo>{

	Vehiculo findById(Integer id);
	List<Vehiculo> findVehicleByUnidad(Integer unidadId);

}
