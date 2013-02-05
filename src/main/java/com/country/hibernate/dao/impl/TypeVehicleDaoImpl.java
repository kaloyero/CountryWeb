package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.TypeVehicleDao;
import com.country.hibernate.model.TipoVehiculo;

@Repository("typeVehicleDao")
public class TypeVehicleDaoImpl extends GenericDaoImpl<TipoVehiculo, Integer> implements TypeVehicleDao{

	@Override
	protected Class<TipoVehiculo> getEntityClass() {
		return TipoVehiculo.class;
	}

}
