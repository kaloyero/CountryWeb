package com.country.services;

import java.util.List;

import com.country.form.ReservaForm;
import com.country.hibernate.model.Reserva;

public interface ReserveManager extends AbstractManager<Reserva>{

	ReservaForm findFormById(Integer id);

	List<Reserva> findListReservationByUnit(Integer id);

	List<Reserva> findListReservationByResource(Integer id);
	
}
