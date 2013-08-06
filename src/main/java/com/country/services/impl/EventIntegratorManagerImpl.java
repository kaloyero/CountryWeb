package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.dao.EventIntegratorDao;
import com.country.hibernate.model.EventoIntegrante;
import com.country.services.EventIntegratorManager;
import com.country.services.EventManager;
import com.country.services.IntegratorManager;

@Service("eventIntegratorManager")
public class EventIntegratorManagerImpl extends AbstractManagerImpl<EventoIntegrante> implements EventIntegratorManager{

	@Autowired
    private EventIntegratorDao eventIntegratorDao;

	@Autowired
    private IntegratorManager integratorManager ;

	@Autowired
    private EventManager eventManager ;

	
	protected GenericDao<EventoIntegrante, Integer> getDao() {
		return eventIntegratorDao;
	}
	
	public List<IntegranteForm> findAllIntegrantorFormByEventoId(Integer id) {
		List<IntegranteForm> list = new ArrayList<IntegranteForm>();
		List<EventoIntegrante> searchList = new ArrayList<EventoIntegrante>();
		searchList = eventIntegratorDao.findAllByProperty("evento", id);
		for (EventoIntegrante dto : searchList) {
			IntegranteForm integrante = integratorManager.findFormById(dto.getIntegrante());
			list.add(integrante);
		}
		
		return list;
	}
	
	@Transactional
	public List<EventoForm> findAllEventByIntegratorId(Integer id) {
		List<EventoForm> list = new ArrayList<EventoForm>();
		List<EventoIntegrante> searchList = new ArrayList<EventoIntegrante>();
		searchList = eventIntegratorDao.findAllByProperty("integrante", id);
		for (EventoIntegrante dto : searchList) {
			EventoForm categoria = eventManager.findFormById(dto.getEvento());
			list.add(categoria);
			
		}
		return list;
	}

	@Transactional
	public boolean inscribirseEvento(int evento, int integrante) {
		boolean inscripcion = true;

		if (esUsuarioInscripto(evento,integrante)){
			inscripcion = false;
		} else {
			//Si no esta inscripto inscribe al usuario
			EventoIntegrante inscrip = new EventoIntegrante();
			inscrip.setEvento(evento);
			inscrip.setIntegrante(integrante);
			eventIntegratorDao.save(inscrip);

		}
		
		return inscripcion;
	}

	@Transactional
	public boolean desinscribirseEvento(int evento, int integrante) {
		boolean desinscripcion = false;
		
		//TODO hacer que borre la inscripcion
		
		return desinscripcion;
	}
	
	@Transactional
	public boolean esUsuarioInscripto(int evento, int integrante) {
		boolean inscripto = true;
		
		EventoIntegrante dto = eventIntegratorDao.findByEventUser(evento, integrante);
		if (dto == null  || dto.getId() == 0  ){
			//el usuario no esta inscripto
			inscripto = false;
		}
		
		return inscripto;
	}
	
}
