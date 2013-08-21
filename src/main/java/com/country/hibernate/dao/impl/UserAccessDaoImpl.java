package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.UserAccessDao;
import com.country.hibernate.model.UsuarioAccesos;

@Repository("userAccessDao")
public class UserAccessDaoImpl extends GenericDaoImpl<UsuarioAccesos, Integer> implements  UserAccessDao{

	@Override
	protected Class<UsuarioAccesos> getEntityClass() {
		return UsuarioAccesos.class;
	}

    public void update(UsuarioAccesos obj) {
      	getSession().update(obj);
      }
}
