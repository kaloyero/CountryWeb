package com.country.services;

import com.country.hibernate.model.NoticiaCategorias;

public interface NewsCategoryManager extends AbstractManager<NoticiaCategorias>{

	NoticiaCategorias findById(Integer id);
	
}
