package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NewsAttachDao;
import com.country.hibernate.model.NoticiaAdjunto;

@Repository("newsAttachDao")
public class NewsAttachDaoImpl extends GenericDaoImpl<NoticiaAdjunto, Integer> implements NewsAttachDao {

	@Override
	protected Class<NoticiaAdjunto> getEntityClass() {
		return NoticiaAdjunto.class;
	}

}
