package com.country.services;

import com.country.hibernate.model.TipoDocumento;

public interface TypeDocumentManager extends AbstractManager<TipoDocumento>{

	TipoDocumento findById(Integer id);
	
}
