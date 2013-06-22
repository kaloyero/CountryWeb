package com.country.services;

import com.country.hibernate.model.NoticiaAdjunto;

public interface NewsAttachManager extends AbstractManager<NoticiaAdjunto>{

	public NoticiaAdjunto findById(Integer id);	
}
