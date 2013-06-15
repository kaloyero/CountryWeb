package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	/**
	 * Este metodo devuelve todos los Integrantes(FORM) que estan en el eveto. 
	 * 
	 * @param id de evento
	 * @return lista de Integrantes
	 */
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
	
	/**
	 * Este metodo devuelve todas las aviso categorias  (FORM) que esta suscripto el integrante especifico 
	 * 
	 * @param id de Integrante
	 * @return lista de avisos categoria
	 */
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
}
