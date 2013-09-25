package com.country.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.EventDao;
import com.country.hibernate.model.Evento;
import com.country.hibernate.model.EventoIntegrante;

@Repository("eventDao")
public class EventDaoImpl extends GenericDaoImpl<Evento, Integer> implements
		EventDao {

	@Override
	protected Class<Evento> getEntityClass() {
		return Evento.class;
	}

	public void update(Evento obj) {
		getSession().update(obj);
	}

	@Transactional
	public int getEventCreatedByPerson(int idPersona, Date date) {

		DetachedCriteria criteria = createDetachedCriteria();
		criteria.add(Restrictions.eq("persona.id", idPersona));
		criteria.add(Restrictions.ge("fecha", date));
		return (Integer) criteria.getExecutableCriteria(getSession())
				.setProjection(Projections.rowCount()).uniqueResult();

	}

	// @Transactional
	// public Integer getEventoInscriptoByIntegrante(int idIntegrante,Date
	// date){
	//
	// DetachedCriteria criteria =
	// createDetachedCriteria(EventoIntegrante.class);
	// criteria.add(Restrictions.eq("integrante", idIntegrante));
	// criteria.add(Restrictions.in("evento", getEventosVigentes(date)));
	// return (Integer)
	// criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();
	//
	// }

	@Transactional
	public Integer getEventoInscriptoByIntegrante(int idIntegrante, Date date) {
		//TODO rehacer query. Refactorizar el IN
		DetachedCriteria criteria = createDetachedCriteria(EventoIntegrante.class);
		criteria.add(Restrictions.eq("integrante", idIntegrante));
		criteria.add(Restrictions.in("evento", getEventosVigentes(date)));
		return (Integer) criteria.getExecutableCriteria(getSession())
				.setProjection(Projections.rowCount()).uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Collection<Integer> getEventosVigentes(Date date) {
		Collection<Integer> list = new ArrayList<Integer>();
		DetachedCriteria criteria = createDetachedCriteria();
		criteria.setProjection(Projections.property("id"));
		criteria.add(Restrictions.ge("fecha", date));
		list = (Collection<Integer>) criteria.getExecutableCriteria(getSession()).list();
		if (list.size() == 0){
			list.add(0);
		}
		return list;
		

	}

}
