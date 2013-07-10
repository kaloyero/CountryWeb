package com.country.services;

import java.util.List;

import com.country.form.MensajeForm;
import com.country.hibernate.model.Mensaje;

public interface MessageManager extends AbstractManager<Mensaje>{

	MensajeForm findFormById(Integer id);
	
	List<Mensaje> getMessajesCategoryType(String type);

	void save(MensajeForm form);
	
	void closeMessage(MensajeForm form);
	
	void update(MensajeForm form);
	
	
}
