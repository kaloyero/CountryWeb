package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.hibernate.dao.PersonaDao;
import com.country.services.HomeService;


@Service("homeService")
public class HomeServiceImpl implements HomeService{

	@Autowired(required=true)
	private PersonaDao personaDao;
	
	@Transactional(readOnly = true)
	public String getText(){
		
		System.out.println("Re loco che: " + personaDao.findAll().size());
		return "zaraza";
	}

	public PersonaDao getPersonaDao() {
		return personaDao;
	}

	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}
	
	
}
