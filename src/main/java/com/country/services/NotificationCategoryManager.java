package com.country.services;

import com.country.form.AvisoCategoriaForm;
import com.country.hibernate.model.AvisoCategoria;

public interface NotificationCategoryManager extends AbstractManager<AvisoCategoria>{

	AvisoCategoria findById(Integer id);
	
	AvisoCategoriaForm findFormById(int id);
	
}
