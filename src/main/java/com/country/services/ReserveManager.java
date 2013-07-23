package com.country.services;

import java.util.Date;
import java.util.List;

import com.country.form.ReservaForm;
import com.country.hibernate.model.Reserva;

public interface ReserveManager extends AbstractManager<Reserva>{

	void save(ReservaForm form);
	
	ReservaForm findFormById(Integer id);

	List<Reserva> findListReservationByUnit(Integer id);

	List<Reserva> findListReservationByResource(Integer id);

	/**
	 * Este metodo devuelve la reserva anterior a auna reserva especifica 
	 * 
	 * @param resource
	 * @param fecha
	 * @param horaIni
	 * @return
	 */
	public Reserva findResourceBefore(Integer resource, Date fecha, int horaIni);
	
	/**
	 * Este metodo devuelve la reserva posterior a auna reserva especifica
	 *  
	 * @param resource
	 * @param fecha
	 * @param horaIni
	 * @return
	 */
	public Reserva findResourceAfter(Integer resource, Date fecha, int horaIni);

}
