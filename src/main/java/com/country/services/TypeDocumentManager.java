package com.country.services;

import java.util.List;

import com.country.hibernate.model.TipoDocumento;

public interface TypeDocumentManager {

	void save(TipoDocumento dto);
	
	List<TipoDocumento> listAll();
	
}
