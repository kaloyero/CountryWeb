package com.country.hibernate.dao;

import com.country.common.GenericDao;
import com.country.hibernate.model.EventoIntegrante;

public interface EventIntegratorDao extends GenericDao<EventoIntegrante, Integer> {

	EventoIntegrante findByEventUser (int eventId, int userId);
	
	/**
	 * Desinscribe al integrante del evento asociado
	 * 
	 * @param idIntegrante
	 * @param evento
	 */
	void desinscribirIntegranteDeEvento(int idIntegrante,int idEvento);
}
