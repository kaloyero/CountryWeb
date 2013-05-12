package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NewsCategoryDao;
import com.country.hibernate.model.NoticiaCategorias;

@Repository("newsCategoryDao")
public class NewsCategoryDaoImpl extends GenericDaoImpl<NoticiaCategorias, Integer> implements NewsCategoryDao{

	@Override
	protected Class<NoticiaCategorias> getEntityClass() {
		return NoticiaCategorias.class;
	}

}
