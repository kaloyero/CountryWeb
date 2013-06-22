package com.country.services;

import com.country.form.NoticiaForm;
import com.country.hibernate.model.Noticia;

public interface NewsManager extends AbstractManager<Noticia>{

	NoticiaForm findFormById(Integer id);
	
	public int save(NoticiaForm form);
	
}
