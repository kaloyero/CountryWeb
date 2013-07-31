package com.country.services;

import java.util.List;

import com.country.hibernate.model.Telefono;

public interface TelephoneManager extends AbstractManager<Telefono>{

	List<Telefono> findListByIdPerson(Integer id);

	void saveList(String telefonosStrList, int idPerson);
	
	void updateList(String telefonosStrList, int idPerson);

}
