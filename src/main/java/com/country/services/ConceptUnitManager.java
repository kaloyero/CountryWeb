package com.country.services;

import com.country.hibernate.model.UnidadConcepto;

public interface ConceptUnitManager extends AbstractManager<UnidadConcepto>{

	UnidadConcepto findById(Integer id);

}
