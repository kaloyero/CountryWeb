package com.country.services;

import com.country.form.AvisoForm;
import com.country.hibernate.model.Aviso;
import com.country.session.UsuarioInfo;

public interface NotificationManager extends AbstractManager<Aviso>{

	AvisoForm findFormById(int id);
	
	public int save(AvisoForm form,UsuarioInfo user);
	
	public void update(AvisoForm form);
	
}
