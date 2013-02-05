package com.country.services;

import com.country.hibernate.model.Reserva;

public interface ReserveManager extends AbstractManager<Reserva>{

	Reserva findById(Integer id);
	
}
