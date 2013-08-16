package com.country.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.Constants;
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

	@SuppressWarnings("unchecked")
	public List<Instructor> findAll(boolean active) {
    	Criteria criteria = getSession().createCriteria(getEntityClass());
   	 if (active){
   		 criteria.add(Restrictions.like("estado", Constants.TRUE));	 
   	 } else {
   		 criteria.add(Restrictions.like("estado", Constants.FALSE));    		 
   	 }
		
		return ((List<Instructor>) criteria.list());
	}

    
}
