package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.Mensaje;

public interface MessageDao extends GenericDao<Mensaje, Integer> {

	void updateStatus(int idMensaje,String status);
	
	void closeMessage(int idMensaje ,String respuesta);
}
