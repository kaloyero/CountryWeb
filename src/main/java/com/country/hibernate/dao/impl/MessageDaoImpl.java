package com.country.hibernate.dao.impl;

import java.util.Date;

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

	public void updateStatus(int idMensaje, int category, String status) {
		Mensaje msj = findById(idMensaje);
		msj.setEstado(status);
		if (category != 0){
			msj.getCategoria().setId(category);
		}
		update(msj);
	}

	public void closeMessage(int idMensaje, String status, Date closeDate, String resolucion) {
		Mensaje msj = findById(idMensaje);
		msj.setEstado(status);
		msj.setFechaCierre(closeDate);
		msj.setResolucion(resolucion);
		update(msj);
	}

}
