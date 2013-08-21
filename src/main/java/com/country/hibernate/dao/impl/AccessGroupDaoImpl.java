package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.AccessGroupDao;
import com.country.hibernate.model.AccesoGrupo;

@Repository("accessGroupDao")
public class AccessGroupDaoImpl extends GenericDaoImpl<AccesoGrupo, Integer> implements AccessGroupDao{

	@Override
	protected Class<AccesoGrupo> getEntityClass() {
		return AccesoGrupo.class;
	}

    public void update(AccesoGrupo obj) {
      	getSession().update(obj);
      }
}
