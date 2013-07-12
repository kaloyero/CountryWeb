package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.MessageDao;
import com.country.hibernate.model.Mensaje;

@Repository("messageDao")
public class MessageDaoImpl extends GenericDaoImpl<Mensaje, Integer> implements MessageDao{

	@Override
	protected Class<Mensaje> getEntityClass() {
		return Mensaje.class;
	}

	public void updateStatus(int idMensaje, String status) {
		// TODO hacer metodo
	}

	public void closeMessage(int idMensaje, String respuesta) {
		// TODO hacer metodo	
	}

}
