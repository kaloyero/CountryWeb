package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.MessageCategoryDao;
import com.country.hibernate.model.MensajeCategorias;

@Repository("messageCategoryDao")
public class MessageCategoryDaoImpl extends GenericDaoImpl<MensajeCategorias, Integer> implements MessageCategoryDao{

	@Override
	protected Class<MensajeCategorias> getEntityClass() {
		return MensajeCategorias.class;
	}

}
