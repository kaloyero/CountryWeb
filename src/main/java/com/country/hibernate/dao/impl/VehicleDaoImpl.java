package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.VehicleDao;
import com.country.hibernate.model.Vehiculo;

@Repository("vehicleDao")
public class VehicleDaoImpl extends GenericDaoImpl<Vehiculo, Integer> implements VehicleDao{

	@Override
	protected Class<Vehiculo> getEntityClass() {
		return Vehiculo.class;
	}

    public void update(Vehiculo obj) {
  	  getSession().update(obj);
  }

	
}
