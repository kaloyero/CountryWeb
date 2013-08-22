package com.country.hibernate.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Empleado findEmployeeByIdPerson(int idPerson) {
        DetachedCriteria criteria = createDetachedCriteria();
        criteria.add(Restrictions.eq("persona.id", idPerson));
        return (Empleado) criteria.getExecutableCriteria(getSession()).uniqueResult();
  }

}
