package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ConceptDao;
import com.country.hibernate.model.Concepto;
import com.country.services.ConceptManager;

@Service("conceptManager")
public class ConceptManagerImpl extends AbstractManagerImpl<Concepto> implements ConceptManager{

	@Autowired
    private ConceptDao conceptDao;

	protected GenericDao<Concepto, Integer> getDao() {
		return conceptDao;
	}

	
	public Concepto findById(Integer id) {
		Concepto dto = conceptDao.findById(id);
		return dto;
	}
	
}
