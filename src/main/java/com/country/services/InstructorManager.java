package com.country.services;

import java.util.List;

import com.country.hibernate.model.Instructor;

public interface InstructorManager {


	Integer save(Instructor dto);
	
	Instructor findById(Integer id);
	
	List<Instructor> listAll();
	
}
