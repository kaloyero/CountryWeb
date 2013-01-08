package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.hibernate.dao.InstructorDao;
import com.country.hibernate.model.Instructor;
import com.country.services.InstructorManager;

@Service("instructorManager")
public class InstructorManagerImpl implements InstructorManager{

	@Autowired
    private InstructorDao instructorDao;
	
	public void save(Instructor dto) {
		instructorDao.saveOrUpdate(dto);
	}

	public List<Instructor> listAll() {
		List<Instructor> list = new ArrayList<Instructor>();
		list = instructorDao.findAll();
		return list;
	}

	public Instructor findById(Integer id) {
		Instructor dto = instructorDao.findById(id);
		return dto;
	}
	
}
