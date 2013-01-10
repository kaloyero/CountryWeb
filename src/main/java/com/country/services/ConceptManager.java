package com.country.services;

import com.country.hibernate.model.Concepto;

public interface ConceptManager extends AbstractManager<Concepto>{

	Concepto findById(Integer id);

	
}
