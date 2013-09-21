package com.country.services;

import com.country.form.AvisoForm;
import com.country.hibernate.model.Aviso;

public interface NotificationManager extends AbstractManager<Aviso>{

	AvisoForm findFormById(int id);
	
	public int save(AvisoForm form);
	
	public void update(AvisoForm form);
	
}
