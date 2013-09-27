package com.country.services;

import java.util.List;

import com.country.form.ActividadForm;
import com.country.form.IntegranteActividadForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.IntegranteActividades;

public interface IntegratorActivityManager extends AbstractManager<IntegranteActividades>{
	
	/**
	 * Trae los id
	 * 
	 * @param id
	 * @return
	 */
	IntegranteActividadForm findFormById(Integer id);
	
	
	/**
	 * Trae la informacion completa con actividad e integrante
	 * 
	 * @param id
	 * @return
	 */
	public IntegranteActividadForm findFormByIdComplete(Integer id);
	
	/**
	 * Inscribir el integrante a una actividad
	 * 
	 * @param integrante
	 * @param actividad
	 * @param fechaIni
	 * @param fechaFin
	 */
	public void inscribirse(int integrante, int actividad, int cronograma, String fechaIni,String fechaFin);
	
	/**
	 * Inscribir el integrante a una actividad
	 * 
	 * @param form
	 */
	void inscribirse(IntegranteActividadForm form);

	/**
	 * desInscribe al integrante de una actividad y sus cronogramas
	 * 
	 * @param actividad
	 * @param integrante
	 */
	public void desinscribirseActividad(int actividad, int integrante); 
	
	/**
	 * desInscribe al integrante de un cronograma
	 * 
	 * @param cronograma
	 * @param integrante
	 */
	public void desinscribirseCronograma(int cronograma, int integrante);
	
	void update(IntegranteActividadForm form);
	
	public List<IntegranteForm> findAllIntegrantorFormByActivityId(Integer id);
	
	public List<ActividadForm> findAllActivitiesByIntegratorId(Integer id);

	
	/**
	 * Este servicio devielve TRUE si el usuario esta inscripto o FALSE si no lo esta.
	 *  
	 * @param actividad
	 * @param integrante
	 * @return
	 */
	public boolean esUsuarioInscripto(int actividad, int integrante);
	
	
	/**
	 * Este metodo devuelve todas las reservas con la informacion de la actividad e integrante
	 * 
	 * @return
	 */
	public List<IntegranteActividadForm> listAllFormsComplete(); 
	
	/**
	 * Devuelve la cantidad de actividades a la que esta inscripto el integrante
	 * 
	 * @return
	 */
	Integer getNumActividadInscriptoByIntegrator ();
	
	/**
	 * Devuelve la cantidad de actividades a la que esta inscripto la unidad
	 * 
	 * @param activityId
	 * @param unidadId
	 * @return
	 */
	Integer getNumActividadInscriptoByUnidad ();

	
	
}
