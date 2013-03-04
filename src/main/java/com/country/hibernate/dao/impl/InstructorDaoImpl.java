package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.InstructorDao;
import com.country.hibernate.model.Instructor;

@Repository("instructorDao")
public class InstructorDaoImpl extends GenericDaoImpl<Instructor, Integer> implements InstructorDao{

	@Override
	protected Class<Instructor> getEntityClass() {
		return Instructor.class;
	}

    public void update(Instructor instructor) {
    	  getSession().update(instructor);
      }

}
