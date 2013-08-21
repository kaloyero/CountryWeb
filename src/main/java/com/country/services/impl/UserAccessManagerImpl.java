package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.UserAccessDao;
import com.country.hibernate.model.UsuarioAccesos;
import com.country.services.UserAccessManager;

@Service("userAccessManager")
public class UserAccessManagerImpl extends AbstractManagerImpl<UsuarioAccesos> implements UserAccessManager{

	@Autowired
    private UserAccessDao userAccessDao;

	protected GenericDao<UsuarioAccesos, Integer> getDao() {
		return userAccessDao;
	}
	
	public UsuarioAccesos findById(Integer id) {
		UsuarioAccesos dto = userAccessDao.findById(id);
		return dto;
	}
	
}
