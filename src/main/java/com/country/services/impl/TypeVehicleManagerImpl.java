package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TypeVehicleDao;
import com.country.hibernate.model.TipoVehiculo;
import com.country.services.TypeVehicleManager;

@Service("typeVehicleManager")
public class TypeVehicleManagerImpl extends AbstractManagerImpl<TipoVehiculo> implements TypeVehicleManager{

	@Autowired
    private TypeVehicleDao typeVehicleDao;
	
	protected GenericDao<TipoVehiculo, Integer> getDao() {
		return typeVehicleDao;
	}
	
	public TipoVehiculo findById(Integer id) {
		TipoVehiculo dto = typeVehicleDao.findById(id);
		return dto;
	}

}
