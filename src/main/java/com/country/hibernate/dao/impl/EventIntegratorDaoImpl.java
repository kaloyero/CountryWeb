package com.country.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.EventIntegratorDao;
import com.country.hibernate.model.EventoIntegrante;

@Repository("eventIntegratorDao")
public class EventIntegratorDaoImpl extends GenericDaoImpl<EventoIntegrante, Integer> implements EventIntegratorDao{

	@Override
	protected Class<EventoIntegrante> getEntityClass() {
		return EventoIntegrante.class;
	}
	
	public EventoIntegrante findByEventUser (int eventId, int userId){
  	  Criteria criteria = getSession().createCriteria(getEntityClass());
  	  criteria.add(Restrictions.eq("evento", eventId));
  	  criteria.add(Restrictions.eq("integrante", userId));
 
      return (EventoIntegrante) criteria.uniqueResult();
		
		
	}

}
