package com.country.services;

import com.country.hibernate.model.Instructor;

public interface InstructorManager extends AbstractManager<Instructor>{

	Instructor findById(Integer id);
	
}
