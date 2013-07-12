package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.ConceptUnitDao;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.UnidadConcepto;
import com.country.services.ConceptUnitManager;

@Service("conceptUnitManager")
public class ConceptUnitManagerImpl extends AbstractManagerImpl<UnidadConcepto> implements ConceptUnitManager{

	@Autowired
    private ConceptUnitDao conceptUnitDao;

	protected GenericDao<UnidadConcepto, Integer> getDao() {
		return conceptUnitDao;
	}
	
	public UnidadConcepto findById(Integer id) {
		UnidadConcepto dto = conceptUnitDao.findById(id);
		return dto;
	}
	
	@Transactional
	public void save(Concepto dto, Double tarifa) {
		
		//TODO
		
	}
	
	@Transactional
	public void update(Concepto dto,Double tarifa) {
		
		//TODO

	}
	
}
