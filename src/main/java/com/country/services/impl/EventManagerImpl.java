package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDao;
import com.country.common.SessionUtil;
import com.country.form.EventoForm;
import com.country.form.PersonaForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.dao.EventDao;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Reserva;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.EventoMapper;
import com.country.services.ConceptManager;
import com.country.services.EventManager;
import com.country.services.PriceManager;
import com.country.services.ReserveManager;
import com.country.session.UsuarioInfo;

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
		Tarifa tarifa = null;
		//Traigo la reserva
		Reserva reserva = reserveManager.findReserveByIdEvent(id);
		//Si el evento es gratis no tiene concepto
		if (evento.getConcepto() != null)
			//Toma la ultima tarifa
			tarifa = priceManager.getLastPriceByConcept(evento.getConcepto().getId());
		
		form = (EventoForm) EventoMapper.getForm(evento, tarifa,reserva);
		return form;
	}
	
	
	@Transactional
	public void save(EventoForm form,UsuarioInfo user) {
		
		int idPerson = user.getPersonaId();
		if (SessionUtil.isEmployeePerson( user.getTipoUsuario())){
			if (! form.isEnvioAdm()){
			   idPerson = form.getPersonaId();
			}
		}
		form.setPersonaId(idPerson);
			
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
		//Pregunto si hay un recurso seleccionado
		if (form.getRecurso() >0){
			ReservaForm reserva = getReserva(form,dto.getId());
			reserveManager.save(reserva,user);
		}
		
		
		
		
	}
	
	
	private ReservaForm getReserva(EventoForm form,int eventId){
		ReservaForm reserva = new ReservaForm();
		reserva.setDuracion(form.getDuracion());
		reserva.setEventoId(eventId);
		reserva.setFecha(form.getFecha());
		reserva.setHoraIni(form.getHourIni());
		PersonaForm intForm = new PersonaForm();
		intForm.setId(form.getPersonaId());
		reserva.setPersona(intForm);
		reserva.setPersonId(form.getPersonaId());
		RecursoForm recFrom = new RecursoForm();
		recFrom.setId(form.getRecurso());
		reserva.setRecurso(recFrom);
		reserva.setRecursoId(form.getRecurso());
		reserva.setDescripcion(form.getDescripcion());
		reserva.setEnvioAdm(form.isEnvioAdm());
		reserva.setId(form.getReservaId());
		return reserva;
	}

	@Transactional
	public void update(EventoForm form) {
		Evento dto = EventoMapper.getEvento(form);

		conceptManager.update(dto.getConcepto(),form.getConcepto().getImporte());
		
		eventDao.update(dto);
		
		//Pregunto si hay un recurso seleccionado
		if (form.getRecurso() >0){
			ReservaForm reserva = getReserva(form,dto.getId());
			reserveManager.update(reserva);
		}
	
	}

	
	public List<EventoForm> listAllForms() {
		List<EventoForm> list = new ArrayList<EventoForm>();
		List<Evento> eventos = eventDao.findAll(false);
		Tarifa tarifa ;
		
		for (Evento evento : eventos) {
			//Traigo la reserva
			Reserva reserva = reserveManager.findReserveByIdEvent(evento.getId());
			tarifa = null;
			//Toma la ultima tarifa
			if (evento.getConcepto() != null){
				tarifa = priceManager.getLastPriceByConcept(evento.getConcepto().getId());

			}		
			
			EventoForm form = (EventoForm) EventoMapper.getForm(evento, tarifa,reserva);


			list.add(form);
		}
		return list;
	}

}
