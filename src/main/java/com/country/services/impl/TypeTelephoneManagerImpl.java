package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.TypeTelephoneDao;
import com.country.hibernate.model.TipoTelefono;
import com.country.services.TypeTelephoneManager;

@Service("typeTelephoneManager")
public class TypeTelephoneManagerImpl implements TypeTelephoneManager{

	@Autowired
    private TypeTelephoneDao typeTelephoneDao;
	
	public void save(TipoTelefono dto) {
		typeTelephoneDao.saveOrUpdate(dto);
	}

	public List<TipoTelefono> listAll() {
		List<TipoTelefono> list = new ArrayList<TipoTelefono>();
		list = typeTelephoneDao.findAll();
		return list;
	}
	
}
