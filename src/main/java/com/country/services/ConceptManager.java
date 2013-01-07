package com.country.services;

import java.util.List;

import com.country.hibernate.model.Concepto;

public interface ConceptManager {

	void save(Concepto dto);
	
	Concepto findById(Integer id);
	
	List<Concepto> listAll();
	
}
