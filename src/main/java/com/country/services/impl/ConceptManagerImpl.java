package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.ConceptDao;
import com.country.hibernate.model.Concepto;
import com.country.services.ConceptManager;

@Service("conceptManager")
public class ConceptManagerImpl implements ConceptManager{

	@Autowired
    private ConceptDao conceptDao;
	
	public void save(Concepto dto) {
		conceptDao.saveOrUpdate(dto);
	}

	public List<Concepto> listAll() {
		List<Concepto> list = new ArrayList<Concepto>();
		list = conceptDao.findAll();
		return list;
	}

	public Concepto findById(Integer id) {
		Concepto dto = conceptDao.findById(id);
		return dto;
	}
	
}
