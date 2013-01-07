package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypeDocumentDao;
import com.country.hibernate.model.TipoDocumento;

@Repository("typeDocumentDao")
public class TypeDocumentDaoImpl extends GenericDaoImpl<TipoDocumento, Integer> implements TypeDocumentDao{

	@Override
	protected Class<TipoDocumento> getEntityClass() {
		return TipoDocumento.class;
	}

}
