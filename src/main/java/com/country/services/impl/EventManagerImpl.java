package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.dao.EventDao;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.EventoMapper;
import com.country.services.ConceptManager;
import com.country.services.EventManager;
import com.country.services.PriceManager;
import com.country.services.ReserveManager;

@Service("eventManager")
public class EventManagerImpl extends AbstractManagerImpl<Evento> implements EventManager{

	@Autowired
    private EventDao eventDao;
	
	@Autowired
    private ConceptManager conceptManager;

	@Autowired
    private PriceManager priceManager;

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
		
		Evento evento = findById(id);
		//Toma la ultima tarifa
		Tarifa tarifa = priceManager.getLastPriceByConcept(evento.getConcepto().getId());
		
		form = (EventoForm) EventoMapper.getForm(evento, tarifa);
		return form;
	}
	
	
	@Transactional
	public void save(EventoForm form) {
		Evento dto = EventoMapper.getEvento(form);
		
		eventDao.save(dto);
		
		//Guarda el importe
		Tarifa price = new Tarifa();
		if (dto.getConcepto() != null){
			price.setConcepto(dto.getConcepto().getId());
			price.setImporte(form.getConcepto().getImporte());
			price.setFechaComienzo(DateUtil.getDateToday());
			priceManager.save(price);		
		}
		ReservaForm reserva = getReserva(form);
		reserveManager.save(reserva);
		
		
		
	}
	
	
	private ReservaForm getReserva(EventoForm form){
		ReservaForm reserva = new ReservaForm();
		reserva.setDuracion(form.getDuracion());
		reserva.setEventoId(form.getId());
		reserva.setFecha(form.getFecha());
		reserva.setHoraIni(form.getHourIni());
		IntegranteForm intForm = new IntegranteForm();
		intForm.setId(form.getIntegrante());
		reserva.setIntegranteId(form.getIntegrante());
		RecursoForm recFrom = new RecursoForm();
		recFrom.setId(form.getRecurso());
		reserva.setRecursoId(form.getRecurso());
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
