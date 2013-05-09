package com.country.services;

import java.util.List;

import com.country.hibernate.model.Direccion;

public interface AddressManager extends AbstractManager<Direccion>{

	public List<Direccion> findListByIdPerson(Integer id);
	
}
