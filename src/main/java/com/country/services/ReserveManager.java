    package com.country.services;

import java.util.Date;
import java.util.List;

import com.country.form.ReservaForm;
import com.country.hibernate.model.Reserva;

public interface ReserveManager extends AbstractManager<Reserva>{

	void save(ReservaForm form);
	
	public void update(ReservaForm form);
	
	ReservaForm findFormById(Integer id);

	public ReservaForm findFormByIdCoplete(Integer id);
	
	/**
	 * Este metodo devuelve todas las reservas que pertenecen a una unidad especifica 
	 * 
	 * @param id de unidad
	 * @return lista de reservas
	 */
	List<Reserva> findListReservationByUnit(Integer id);

	/**
	 * Este metodo devuelve todas las reservas que pertenecen a un recurso especifico 
	 * 
	 * @param id de recurso
	 * @return lista de reservas
	 */
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

	/**
	 * Este metodo devuelve la reserva seg[un el evento
	 *  
	 * @param resource
	 * @return
	 */
	public Reserva findReserveByIdEvent(int event);
	
	public List<ReservaForm> listAllFormsComplete();

	/**
	 * Devuelve la cantidad de reservas vigentes que tiene el integrante
	 * 
	 * @return
	 */
	public Integer getReserveNumByPerson();
	
	/**
	 * Devuelve la cantidad de reservas vigentes que tiene la unidad
	 * 
	 * @return
	 */
	public Integer getReserveNumByUnit();
}
