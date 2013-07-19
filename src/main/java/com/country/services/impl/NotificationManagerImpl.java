
package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.AvisoForm;
import com.country.hibernate.dao.NotificationDao;
import com.country.hibernate.model.Aviso;
import com.country.mappers.AvisoMapper;
import com.country.services.NotificationManager;

@Service("notificationManager")
public class NotificationManagerImpl extends AbstractManagerImpl<Aviso> implements NotificationManager{

	@Autowired
    private NotificationDao notificationDao;
	
	protected GenericDao<Aviso, Integer> getDao() {
		return notificationDao;
	}

	public Aviso findById(Integer id) {
		Aviso dto = notificationDao.findById(id);
		return dto;
	}
	
	public AvisoForm findFormById(int id) {
		AvisoForm form = new AvisoForm();

		Aviso dto = findById(id);
		form = (AvisoForm) AvisoMapper.getForm(dto);

		return form;
	}

	@Transactional
	public int save(AvisoForm form) {
		Aviso dto = AvisoMapper.getAviso(form);
		
		getDao().save(dto);

		return dto.getId();
	}

	@Transactional
	public void update(AvisoForm form) {
		Aviso dto = AvisoMapper.getAviso(form);
		
		getDao().update(dto);
	}
	
}
