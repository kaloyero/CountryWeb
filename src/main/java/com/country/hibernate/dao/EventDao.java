package com.country.hibernate.dao;

import java.util.Collection;
import java.util.Date;

import com.country.common.GenericDao;
import com.country.hibernate.model.Evento;

public interface EventDao extends GenericDao<Evento, Integer> {

    /**
     * DEvuelve la cantidad de eventos vigentes para el idPersona.
     * 
     * @param idPersona
     * @return
     */
    public int getEventCreatedByPerson(int idPersona,Date date);
    
    
    /**
     * Devuelve los eventos vigentes a los que se inscribio el Integrante
     * 
     * @param idIntegrante
     * @param date
     * @return
     */
    public Integer getEventoInscriptoByIntegrante(int idIntegrante,Date date);

    /**
     * @param date
     * @return
     */
    public Collection<Integer> getEventosVigentes(Date date);

	
}
