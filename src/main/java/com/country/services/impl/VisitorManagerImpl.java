package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.VisitorDao;
import com.country.hibernate.model.Autorizado;
import com.country.services.VisitorManager;

@Service("vositorManager")
public class VisitorManagerImpl extends AbstractManagerImpl<Autorizado> implements VisitorManager{

	@Autowired
    private VisitorDao visitorDao;
	
	protected GenericDao<Autorizado, Integer> getDao() {
		return visitorDao;
	}

	public Autorizado findById(Integer id) {
		Autorizado dto = visitorDao.findById(id);
		return dto;
	}
	
}
