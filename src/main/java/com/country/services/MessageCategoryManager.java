package com.country.services;

import com.country.hibernate.model.MensajeCategorias;

public interface MessageCategoryManager extends AbstractManager<MensajeCategorias>{

	MensajeCategorias findById(Integer id);
	
}
