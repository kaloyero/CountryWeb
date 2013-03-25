package com.country.services;

import com.country.hibernate.model.Raza;

public interface RazaManager extends AbstractManager<Raza>{

	public Raza findById(Integer id);
	
}
