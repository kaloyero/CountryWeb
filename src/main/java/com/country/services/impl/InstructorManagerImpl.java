package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.InstructorDao;
import com.country.hibernate.model.Instructor;
import com.country.services.InstructorManager;

@Service("instructorManager")
public class InstructorManagerImpl extends AbstractManagerImpl<Instructor> implements InstructorManager{

	@Autowired
    private InstructorDao instructorDao;
	
	protected GenericDao<Instructor, Integer> getDao() {
		return instructorDao;
	}
	
	public Instructor findById(Integer id) {
		Instructor dto = instructorDao.findById(id);
		return dto;
	}
	
}
