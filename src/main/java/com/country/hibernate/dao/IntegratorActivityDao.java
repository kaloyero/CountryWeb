package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.IntegranteActividades;

public interface IntegratorActivityDao extends GenericDao<IntegranteActividades, Integer> {

	IntegranteActividades findByActivityUser (int activityId, int userId);
	
	/**
	 * Devuelve la cantidad de actividades a la que esta inscripto un integrante
	 * 
	 * @param integranteId
	 * @return
	 */
	Integer getNumActividadInscriptoByIntegrator (int integranteId);
	
	/**
	 * Devuelve la cantidad de actividades a la que esta inscripto la unidad
	 *
	 * @param unidadId
	 * @return
	 */
	Integer getNumActividadInscriptoByUnidad (int unidadId);

	
}
