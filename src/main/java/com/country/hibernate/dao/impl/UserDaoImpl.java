package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.UserDao;
import com.country.hibernate.model.Usuario;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UserDao{

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

    public void update(Usuario obj) {
      	getSession().update(obj);
      }
}
