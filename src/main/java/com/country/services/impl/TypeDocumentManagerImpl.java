package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.TypeDocumentDao;
import com.country.hibernate.model.TipoDocumento;
import com.country.services.TypeDocumentManager;

@Service("typeDocumentManager")
public class TypeDocumentManagerImpl implements TypeDocumentManager{

	@Autowired
    private TypeDocumentDao typeDocumentDao;
	
	public void save(TipoDocumento dto) {
		typeDocumentDao.saveOrUpdate(dto);
	}

	public List<TipoDocumento> listAll() {
		List<TipoDocumento> list = new ArrayList<TipoDocumento>();
		list = typeDocumentDao.findAll();
		return list;
	}
	
}
