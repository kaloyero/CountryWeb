package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.MessageCategoryDao;
import com.country.hibernate.model.MensajeCategorias;
import com.country.services.MessageCategoryManager;

@Service("messageCategoryManager")
public class MessageCategoryManagerImpl extends AbstractManagerImpl<MensajeCategorias> implements MessageCategoryManager{

	@Autowired
    private MessageCategoryDao messageCategoryDao;
	
	protected GenericDao<MensajeCategorias, Integer> getDao() {
		return messageCategoryDao;
	}

	public MensajeCategorias findById(Integer id) {
		MensajeCategorias dto = messageCategoryDao.findById(id);
		return dto;
	}

}
