package com.country.services;

import com.country.hibernate.model.Noticia;

public interface NewsManager extends AbstractManager<Noticia>{

	Noticia findById(Integer id);
	
}
