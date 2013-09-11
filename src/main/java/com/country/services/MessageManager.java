package com.country.services;

import java.util.List;

import com.country.form.MensajeForm;
import com.country.hibernate.model.Mensaje;
import com.country.session.UsuarioInfo;

public interface MessageManager extends AbstractManager<Mensaje>{

	MensajeForm findFormById(Integer id);
	
	List<Mensaje> getMessajesCategoryType(String type);

	void save(MensajeForm form,UsuarioInfo user);
	
	void closeMessage(MensajeForm form);
	
	void update(MensajeForm form,UsuarioInfo user);

	List<MensajeForm> listAllForms(String type);
	
}
