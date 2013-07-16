package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.EventoForm;
import com.country.hibernate.dao.EventDao;
import com.country.hibernate.model.Evento;
import com.country.mappers.EventoMapper;
import com.country.services.ConceptManager;
import com.country.services.EventManager;

@Service("eventManager")
public class EventManagerImpl extends AbstractManagerImpl<Evento> implements EventManager{

	@Autowired
    private EventDao eventDao;
	
	@Autowired
    private ConceptManager conceptManager;

	
	protected GenericDao<Evento, Integer> getDao() {
		return eventDao;
	}

	@Transactional
	private Evento findById(Integer id) {
		Evento dto = eventDao.findById(id);
		return dto;
	}

	
	public EventoForm findFormById(Integer id) {
		EventoForm form = new EventoForm();
		return form;
	}
	
	
	@Transactional
	public void save(EventoForm form) {
		Evento dto = EventoMapper.getEvento(form);
		
		conceptManager.save(dto.getConcepto(),form.getConcepto().getImporte());
		
		eventDao.save(dto);
		
	}

	@Transactional
	public void update(EventoForm form) {
		Evento dto = EventoMapper.getEvento(form);

		conceptManager.update(dto.getConcepto(),form.getConcepto().getImporte());
		
		eventDao.update(dto);
		
	}

}
