package com.country.services;

import com.country.hibernate.model.MensajeDetalles;

public interface MessageDetailManager extends AbstractManager<MensajeDetalles>{

	MensajeDetalles findById(Integer id);
	
	//public List<MensajeDetalles> getDetailsByMessajeId(Integer id);
	MensajeDetalles getFirstDetailMessage(int idMessage);
	
	MensajeDetalles getLastDetailMessage(int idMessage);

}
