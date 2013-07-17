package com.country.hibernate.dao;

import java.util.Date;

import com.country.common.GenericDao;
import com.country.hibernate.model.Mensaje;

public interface MessageDao extends GenericDao<Mensaje, Integer> {

	void updateStatus(int idMensaje , int category, String status);
	
	void closeMessage(int idMensaje, String status, Date closeDate, String resolucion);
}
