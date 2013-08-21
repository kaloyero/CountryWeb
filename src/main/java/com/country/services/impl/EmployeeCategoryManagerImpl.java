package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.EmployeeCategoryDao;
import com.country.hibernate.model.EmpleadoCategoria;
import com.country.services.EmployeeCategoryManager;

@Service("EmployeeCategoryManager")
public class EmployeeCategoryManagerImpl extends AbstractManagerImpl<EmpleadoCategoria> implements EmployeeCategoryManager{

	@Autowired
    private EmployeeCategoryDao employeeCategoryDao;

	protected GenericDao<EmpleadoCategoria, Integer> getDao() {
		return employeeCategoryDao;
	}
	
	public EmpleadoCategoria findById(Integer id) {
		EmpleadoCategoria dto = employeeCategoryDao.findById(id);
		return dto;
	}
	
}
