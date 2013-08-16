package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.Constants;
import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.hibernate.dao.UserDao;
import com.country.hibernate.model.Usuario;
import com.country.services.UserManager;

@Service("UserManager")
public class UserManagerImpl extends AbstractManagerImpl<Usuario> implements UserManager{

	@Autowired
    private UserDao userDao;

	protected GenericDao<Usuario, Integer> getDao() {
		return userDao;
	}
	
	public Usuario findById(Integer id) {
		Usuario dto = userDao.findById(id);
		return dto;
	}
	
	public void save (Usuario dto){
		//Setea que es el primer acceso
		dto.setResetPass(Constants.TRUE);
		dto.setFechaDesde(DateUtil.getDateToday());
		userDao.save(dto);
	}
	
}
