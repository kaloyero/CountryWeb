package com.country.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.MessageDetailDao;
import com.country.hibernate.model.MensajeDetalles;

@Repository("messageDetailDao")
public class MessageDetailDaoImpl extends GenericDaoImpl<MensajeDetalles, Integer> implements MessageDetailDao{

	@Override
	protected Class<MensajeDetalles> getEntityClass() {
		return MensajeDetalles.class;
	}

}
