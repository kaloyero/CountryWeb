package com.country.services;

import java.util.List;

import com.country.hibernate.model.Telefono;

public interface TelephoneManager extends AbstractManager<Telefono>{

	public List<Telefono> findListByIdPerson(Integer id);
	
}
