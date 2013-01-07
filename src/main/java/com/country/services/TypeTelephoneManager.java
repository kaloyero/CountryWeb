package com.country.services;

import java.util.List;

import com.country.hibernate.model.TipoTelefono;

public interface TypeTelephoneManager {

	void save(TipoTelefono dto);
	
	List<TipoTelefono> listAll();
	
}
