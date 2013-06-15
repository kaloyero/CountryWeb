package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.form.AvisoCategoriaForm;
import com.country.hibernate.dao.NotificationCategoryDao;
import com.country.hibernate.model.AvisoCategoria;
import com.country.mappers.AvisoCategoriaMapper;
import com.country.services.NotificationCategoryManager;

@Service("notificationCategoryManager")
public class NotificationCategoryManagerImpl extends AbstractManagerImpl<AvisoCategoria> implements NotificationCategoryManager{

	@Autowired
    private NotificationCategoryDao notificationCategoryDao;
	
	protected GenericDao<AvisoCategoria, Integer> getDao() {
		return notificationCategoryDao;
	}

	public AvisoCategoria findById(Integer id) {
		AvisoCategoria dto = notificationCategoryDao.findById(id);
		return dto;
	}

	public AvisoCategoriaForm findFormById(int id) {
		AvisoCategoriaForm form = new AvisoCategoriaForm();
		
		AvisoCategoria dto = findById(id);
		form = (AvisoCategoriaForm) AvisoCategoriaMapper.getForm(dto);
		
		return form;
	}
	
	
}
