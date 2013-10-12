package com.country.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.DateUtil;
import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.model.Actividad;

@Repository("activityDao")
public class ActivityDaoImpl extends GenericDaoImpl<Actividad, Integer> implements ActivityDao{

	@Override
	protected Class<Actividad> getEntityClass() {
		return Actividad.class;
	}
	
    public void update(Actividad obj) {
    	getSession().update(obj);
    }
	
    @SuppressWarnings("unchecked")
	@Transactional
    public Collection<Integer> getActividadVigentes(){
    	Collection<Integer> list = new ArrayList<Integer>();
    	DetachedCriteria criteria = createDetachedCriteria();
        criteria.setProjection(Projections.property("id"));
        //TODO agregar campo Estado para obtener solo las actividades activas.
        //criteria.add(Restrictions.ge("fecha", date));
        list = (Collection<Integer>) criteria.getExecutableCriteria(getSession()).list();
		if (list.size() == 0){
			list.add(0);
		}
		return list;
    }

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Actividad> getActividadInscriptoByDate(int idIntegrante,
			String fechaDesde, String fechaHasta, int cantDias) {
		Query qry = getSession().createQuery(
					"FROM Actividad ac WHERE "+
						"ac.fechaComienzo >= :fechaDesde "+
					"and ac.fechaFin <= :fechaHasta "+
					"and exists (SELECT 0 FROM IntegranteActividades ia WHERE ia.integrante like :integrante and ia.actividad = ac.id)"
			);
		qry.setParameter("integrante", idIntegrante);
		qry.setParameter("fechaDesde", DateUtil.convertStringToDate(fechaDesde));
		//Si la fecha hasta viene null le sumo cantidad de dias para saber la fecha hasta
		if (fechaHasta != null){
			qry.setParameter("fechaHasta",DateUtil.convertStringToDate(fechaHasta));	
		} else {
			qry.setParameter("fechaHasta",DateUtil.sumarDias(DateUtil.convertStringToDate(fechaDesde),cantDias));	
		}
	
		return (List<Actividad>) qry.list();
		
	}

}
