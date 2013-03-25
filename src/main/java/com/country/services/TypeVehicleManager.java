package com.country.services;

import com.country.hibernate.model.TipoVehiculo;

public interface TypeVehicleManager extends AbstractManager<TipoVehiculo>{

	TipoVehiculo findById(Integer id);
}
