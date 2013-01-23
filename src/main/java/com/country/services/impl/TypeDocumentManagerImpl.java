package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypeDocumentDao;
import com.country.hibernate.model.TipoDocumento;
import com.country.services.TypeDocumentManager;

@Service("typeDocumentManager")
public class TypeDocumentManagerImpl extends AbstractManagerImpl<TipoDocumento> implements TypeDocumentManager{

	@Autowired
    private TypeDocumentDao typeDocumentDao;

	protected GenericDao<TipoDocumento, Integer> getDao() {
		return typeDocumentDao;
	}

	
}
