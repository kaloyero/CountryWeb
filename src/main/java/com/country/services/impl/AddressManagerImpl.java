package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.AddressDao;
import com.country.hibernate.model.Direccion;
import com.country.services.AddressManager;

@Service("addressManager")
public class AddressManagerImpl extends AbstractManagerImpl<Direccion> implements AddressManager{

	@Autowired
    private AddressDao addressDao;
	
	protected GenericDao<Direccion, Integer> getDao() {
		return addressDao;
	}

	public List<Direccion> findListByIdPerson(Integer id) {
		List<Direccion> list = addressDao.findAllByProperty("person", id);
		return list;
	}

}
