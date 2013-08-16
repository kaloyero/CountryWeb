package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.EmployeeDao;
import com.country.hibernate.model.Empleado;

@Repository("employeeDao")
public class EmployeeDaoImpl extends GenericDaoImpl<Empleado, Integer> implements EmployeeDao{

	@Override
	protected Class<Empleado> getEntityClass() {
		return Empleado.class;
	}

    public void update(Empleado obj) {
      	getSession().update(obj);
      }
}
