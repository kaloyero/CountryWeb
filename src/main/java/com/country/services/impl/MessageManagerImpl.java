package com.country.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.MensajeForm;
import com.country.hibernate.dao.MessageDao;
import com.country.hibernate.dao.MessageDetailDao;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.country.mappers.MensajeMapper;
import com.country.services.MessageManager;

@Service("messageManager")
public class MessageManagerImpl extends AbstractManagerImpl<Mensaje> implements MessageManager{

	@Autowired
    private MessageDao messageDao;
	
	@Autowired
    private MessageDetailDao messageDetailDao;

	
	protected GenericDao<Mensaje, Integer> getDao() {
		return messageDao;
	}

	@Transactional
	private Mensaje findById(Integer id) {
		Mensaje dto = messageDao.findById(id);
		return dto;
	}

	public MensajeForm findFormById(Integer id) {
		MensajeForm form = new MensajeForm();
		
		Mensaje dto = findById(id);
		List<MensajeDetalles> detalles = messageDetailDao.findAllByProperty("mensaje", id);
		
		form = (MensajeForm) MensajeMapper.getForm(dto,detalles);
		
		return form;
	}

}
