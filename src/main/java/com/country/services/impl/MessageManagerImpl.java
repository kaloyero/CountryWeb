package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.MessageDao;
import com.country.hibernate.model.Mensaje;
import com.country.services.MessageManager;

@Service("messageManager")
public class MessageManagerImpl extends AbstractManagerImpl<Mensaje> implements MessageManager{

	@Autowired
    private MessageDao messageDao;
	
	protected GenericDao<Mensaje, Integer> getDao() {
		return messageDao;
	}

	public Mensaje findById(Integer id) {
		Mensaje dto = messageDao.findById(id);
		return dto;
	}

}
