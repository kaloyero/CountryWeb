package com.country.services;

import java.util.List;

import com.country.hibernate.model.MensajeDetalles;

public interface MessageDetailManager extends AbstractManager<MensajeDetalles>{

	MensajeDetalles findById(Integer id);
	
	public List<MensajeDetalles> getDetailsByMessajeId(Integer id);
	
}
