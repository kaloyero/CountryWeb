package com.country.services;

import java.util.List;

import com.country.form.TelefonoForm;
import com.country.hibernate.model.Telefono;

public interface TelephoneManager extends AbstractManager<Telefono>{

	List<Telefono> findListByIdPerson(Integer id);

	void updateFormList(List<TelefonoForm> telefonos, int idPerson);

	void saveFormList(List<TelefonoForm> telefonos, int idPerson);

}
