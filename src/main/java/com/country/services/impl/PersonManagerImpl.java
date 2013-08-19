package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.PersonaForm;
import com.country.hibernate.dao.PersonaDao;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.Telefono;
import com.country.mappers.PersonaMapper;
import com.country.services.AddressManager;
import com.country.services.PersonManager;
import com.country.services.TelephoneManager;

@Service("personManager")
public class PersonManagerImpl extends AbstractManagerImpl<Persona> implements PersonManager{


	@Autowired
	private PersonaDao personaDao;

	@Autowired
	private TelephoneManager telephoneManager;

	@Autowired
	private AddressManager addressManager;

	protected GenericDao<Persona, Integer> getDao() {
		return personaDao;
	}

	@Transactional
	public PersonaForm findFormById(Integer id) {
		PersonaForm form = new PersonaForm();
		
		Persona dto = personaDao.findById(id);
		List<Telefono> telefonos = telephoneManager.findListByIdPerson(dto.getId());
		List<Direccion> direcciones = addressManager.findListByIdPerson(dto.getId());
		
		form = (PersonaForm) PersonaMapper.getForm(dto,direcciones,telefonos);
		
		return form;
	}

}