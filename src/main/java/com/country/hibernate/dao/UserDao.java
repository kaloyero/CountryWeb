package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.Usuario;

public interface UserDao extends GenericDao<Usuario, Integer> {

	public Usuario checkUser(String user, String password);
}
