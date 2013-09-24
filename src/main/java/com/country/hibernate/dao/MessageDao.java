package com.country.hibernate.dao;

import java.util.Date;

import com.country.common.GenericDao;
import com.country.hibernate.model.Mensaje;

public interface MessageDao extends GenericDao<Mensaje, Integer> {

	void updateStatus(int idMensaje , int category, String status);
	
	void closeMessage(int idMensaje, String status, Date closeDate, String resolucion);
	
	
	/**
	 * Este metodo  devuelve por integrante la cantidad de reclamos en el "estado" que se especifique
	 * 
	 * @param idIntegrante
	 * @param tipoMensaje 
	 * @param envioPor Esta variable define si lo abrio el integrante.
	 * @param estado
	 * @return
	 */
	public int getNumReclamosByIntegrante(int idIntegrante,String tipoMensaje,String envioPor,String estado);
	
}
