package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NewsValorationDao;
import com.country.hibernate.model.NoticiaValoraciones;

@Repository("newsValorationDao")
public class NewsValorationDaoImpl extends GenericDaoImpl<NoticiaValoraciones, Integer> implements NewsValorationDao {

	@Override
	protected Class<NoticiaValoraciones> getEntityClass() {
		return NoticiaValoraciones.class;
	}

}
