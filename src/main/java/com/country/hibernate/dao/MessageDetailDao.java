package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.MensajeDetalles;

public interface MessageDetailDao extends GenericDao<MensajeDetalles, Integer> {

	public MensajeDetalles getLastDetailByIdMessage(int message);
	
	public MensajeDetalles getFirstDetailByIdMessage(int message);

}
