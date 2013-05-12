package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.TelephoneDao;
import com.country.hibernate.model.Telefono;
import com.country.services.TelephoneManager;

@Service("telephoneManager")
public class TelephoneManagerImpl extends AbstractManagerImpl<Telefono> implements TelephoneManager{

	@Autowired
    private TelephoneDao telephoneDao;
	
	protected GenericDao<Telefono, Integer> getDao() {
		return telephoneDao;
	}

	public List<Telefono> findListByIdPerson(Integer id) {
		
		List<Telefono> list = telephoneDao.findAllByProperty("persona", id);
		return list;
	}

}
