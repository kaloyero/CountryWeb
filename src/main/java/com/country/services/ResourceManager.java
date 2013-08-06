package com.country.services;

import java.util.Date;
import java.util.List;

import com.country.form.RecursoForm;
import com.country.hibernate.model.Recurso;

public interface ResourceManager extends AbstractManager<Recurso>{

	Recurso findById(Integer id);
	int save(RecursoForm form);
	
	RecursoForm getResourceForm(Integer id);
	
	void update(RecursoForm form);

	List<RecursoForm> listAllResourceForm();
	
	/**
	 * Este metodo verifica que el recurso no este reservado en una fechay horario particular.
	 * 
	 * @param resource
	 * @param fecha
	 * @param horaIni
	 * @param duracion
	 * @return
	 */
	boolean checkReserveResourceAvaibility(int resource, Date fecha, int horaIni,int duracion);
	
	/**
	 * Este metodo devuelve si el recurso esta disponible esa dia de la semana en el horario especifico
	 * 
	 * @param resource recurso
	 * @param fecha fecha
	 * @param horaIni hora en que se quiere reservar el recurso
	 * @param duracion duracion
	 * @return true si se puede reservar el recurso
	 */
	boolean checkReserveResourceDisponibility(int resource, Date fecha, int horaIni,int duracion);
	

	/**
	 * Chequea la disponibilidad del recurso y si existe una reserva para esa fecha.
	 * 
	 * @param resource
	 * @param fecha
	 * @param horaIni
	 * @param duracion
	 * @return
	 */
	public boolean checkReserveResource(int resource, Date fecha,int horaIni, int duracion);
	
	
	/**
	 * @return
	 */
	public List<RecursoForm> listAllForms(); 
	
}