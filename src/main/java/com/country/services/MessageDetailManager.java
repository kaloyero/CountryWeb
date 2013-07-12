package com.country.services;

import com.country.hibernate.model.MensajeDetalles;

public interface MessageDetailManager extends AbstractManager<MensajeDetalles>{

	MensajeDetalles findById(Integer id);
	
	//public List<MensajeDetalles> getDetailsByMessajeId(Integer id);
	
	public MensajeDetalles getLastDetailMessage(int idMessage);

}
