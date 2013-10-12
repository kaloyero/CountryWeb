package com.country.hibernate.dao;

import java.util.Collection;
import java.util.List;

import com.country.common.GenericDao;
import com.country.hibernate.model.Actividad;

public interface ActivityDao extends GenericDao<Actividad, Integer> {

	Collection<Integer> getActividadVigentes();

	
    /**
     * Este metodo devuelve todas las actividades para un integrante en una fecha determinada.
     * La fecha fin puede estar dada por fechaHasta o cantDias. Sifecha hasta es 'null' usara cantDias
     * 
     * @param idIntegrante
     * @param fechaDesde
     * @param fechaHasta
     * @param cantDias cantidad de dias.
     * @return
     */
    List<Actividad> getActividadInscriptoByDate(int idIntegrante,String fechaDesde, String fechaHasta, int cantDias);

}
