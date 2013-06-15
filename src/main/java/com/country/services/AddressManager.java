package com.country.services;

import java.util.List;

import com.country.form.DireccionForm;
import com.country.hibernate.model.Direccion;

public interface AddressManager extends AbstractManager<Direccion>{

	public List<Direccion> findListByIdPerson(Integer id);
	
	void saveFormList(List<DireccionForm> direcciones, int idPerson);
	
	void updateFormList(List<DireccionForm> direcciones, int idPerson);
	
}
