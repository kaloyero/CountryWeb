package com.country.services;

import com.country.hibernate.model.Vehiculo;

public interface VehicleManager extends AbstractManager<Vehiculo>{

	Vehiculo findById(Integer id);
	
}
