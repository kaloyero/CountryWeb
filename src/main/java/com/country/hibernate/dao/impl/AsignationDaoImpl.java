package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.AsignationDao;
import com.country.hibernate.model.Asignacion;

@Repository("asignationDao")
public class AsignationDaoImpl extends GenericDaoImpl<Asignacion, Integer> implements AsignationDao{

	@Override
	protected Class<Asignacion> getEntityClass() {
		return Asignacion.class;
	}
	
    public void update(Asignacion obj) {
    	getSession().update(obj);
    }
	

}
