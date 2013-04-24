package com.country.services;

import java.util.List;

import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Unidad;

public interface UnitManager extends AbstractManager<Unidad>{

	Unidad findById(Integer id);
	
	List<Integrante> getIntegrators(Integer id);
}
