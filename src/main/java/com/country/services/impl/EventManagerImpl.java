package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.dao.EventDao;
import com.country.hibernate.model.Evento;
import com.country.mappers.EventoMapper;
import com.country.services.ConceptManager;
import com.country.services.EventManager;
import com.country.services.ReserveManager;

@Service("eventManager")
public class EventManagerImpl extends AbstractManagerImpl<Evento> implements EventManager{

	@Autowired
    private EventDao eventDao;
	
	@Autowired
    private ConceptManager conceptManager;

	@Autowired
    private ReserveManager reserveManager;
		
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

		ReservaForm reserva = getReserva(form);
		reserveManager.save(reserva);
		
		eventDao.save(dto);
		
	}
	
	
	private ReservaForm getReserva(EventoForm form){
		ReservaForm reserva = new ReservaForm();
		reserva.setDuracion(form.getDuracion());
		reserva.setEvento(form);
		reserva.setFecha(form.getFecha());
		reserva.setHoraIni(form.getHourIni());
		IntegranteForm intForm = new IntegranteForm();
		intForm.setId(form.getIntegrante());
		reserva.setIntegrante(intForm);
		RecursoForm recFrom = new RecursoForm();
		recFrom.setId(form.getRecurso());
		reserva.setRecurso(recFrom);
		reserva.setDescripcion(form.getDescripcion());
		
		return reserva;
	}

	@Transactional
	public void update(EventoForm form) {
		Evento dto = EventoMapper.getEvento(form);

		conceptManager.update(dto.getConcepto(),form.getConcepto().getImporte());
		
		eventDao.update(dto);
		
	}

}
