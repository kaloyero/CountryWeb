package com.country.services;

import com.country.form.MensajeForm;
import com.country.hibernate.model.Mensaje;

public interface MessageManager extends AbstractManager<Mensaje>{

	Mensaje findById(Integer id);
	
	MensajeForm getFormByIdMessage(Integer id);
	
}
