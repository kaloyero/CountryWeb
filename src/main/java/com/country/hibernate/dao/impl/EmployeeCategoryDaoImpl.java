package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.EmployeeCategoryDao;
import com.country.hibernate.model.EmpleadoCategoria;

@Repository("employeeCategoryDao")
public class EmployeeCategoryDaoImpl extends GenericDaoImpl<EmpleadoCategoria, Integer> implements  EmployeeCategoryDao{

	@Override
	protected Class<EmpleadoCategoria> getEntityClass() {
		return EmpleadoCategoria.class;
	}

    public void update(EmpleadoCategoria obj) {
      	getSession().update(obj);
      }
}
