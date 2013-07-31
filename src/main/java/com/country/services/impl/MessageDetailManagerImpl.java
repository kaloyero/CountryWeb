package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.MessageDetailDao;
import com.country.hibernate.model.MensajeDetalles;
import com.country.services.MessageDetailManager;

@Service("messageDetailManager")
public class MessageDetailManagerImpl extends AbstractManagerImpl<MensajeDetalles> implements MessageDetailManager{

	@Autowired
    private MessageDetailDao messageDetailDao;
	
	protected GenericDao<MensajeDetalles, Integer> getDao() {
		return messageDetailDao;
	}

	public MensajeDetalles findById(Integer id) {
		MensajeDetalles dto = messageDetailDao.findById(id);
		return dto;
	}

	public List<MensajeDetalles> getDetailsByMessajeId(Integer id) {
		List<MensajeDetalles> list = messageDetailDao.findAllByProperty("mensaje", id);
		return list;
	}

	@Transactional
	public MensajeDetalles getLastDetailMessage(int idMessage){
		MensajeDetalles obj = messageDetailDao.getLastDetailByIdMessage(idMessage);
		return obj;
	}

	@Transactional
	public MensajeDetalles getFirstDetailMessage(int idMessage){
		MensajeDetalles obj = messageDetailDao.getFirstDetailByIdMessage(idMessage);
		return obj;
	}

}
