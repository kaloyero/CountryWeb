
package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.common.SessionUtil;
import com.country.form.AvisoForm;
import com.country.hibernate.dao.NotificationDao;
import com.country.hibernate.model.Aviso;
import com.country.hibernate.model.AvisoCategoria;
import com.country.mappers.AvisoMapper;
import com.country.services.NotificationCategoryManager;
import com.country.services.NotificationManager;
import com.country.session.SessionUsr;

@Service("notificationManager")
public class NotificationManagerImpl extends AbstractManagerImpl<Aviso> implements NotificationManager{

	@Autowired
    private NotificationDao notificationDao;
	
	@Autowired
    private NotificationCategoryManager notificationCategoryManager;
	
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
		//Seteo la persona q crea
		int idPerson = SessionUsr.User().getPersonaId();
		if (SessionUtil.isEmployeePerson( SessionUsr.User().getTipoUsuario())){
			if (! form.isEnvioAdm()){
			   idPerson = form.getPersona();
			}
		}
		form.setPersona(idPerson);
		
		//mapeo el aviso
		Aviso dto = AvisoMapper.getAviso(form);
		
		AvisoCategoria categoria = notificationCategoryManager.findById(form.getCategoria());
		//Seteo la fecha de inicio como la actual
		dto.setFecha(DateUtil.getDateToday());
		//A la fecha de cierre le sumo los dias de publicacion de Aviso Categoria
		dto.setFechaFin(DateUtil.sumarDias(DateUtil.getDateToday(), Integer.parseInt(categoria.getPublishDays())));
		
		getDao().save(dto);

		return dto.getId();
	}

	@Transactional
	public void update(AvisoForm form) {
		Aviso dto = AvisoMapper.getAviso(form);
		
		getDao().update(dto);
	}

    public Integer getNumAvisosByPerson(){
    	return notificationDao.getNumAvisosByPerson(SessionUsr.User().getPersonaId(), DateUtil.getDateTodayDmyFormat());    	
    }
}
