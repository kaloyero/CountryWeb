package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.PersonaDao;
import com.country.hibernate.model.Persona;

@Repository("personaDao")
public class PersonaDaoImpl extends GenericDaoImpl<Persona, Integer> implements PersonaDao{

	@Override
	protected Class<Persona> getEntityClass() {
		return Persona.class;
	}

}
