package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NewsDao;
import com.country.hibernate.model.Noticia;

@Repository("newsDao")
public class NewsDaoImpl extends GenericDaoImpl<Noticia, Integer> implements NewsDao{

	@Override
	protected Class<Noticia> getEntityClass() {
		return Noticia.class;
	}

}
