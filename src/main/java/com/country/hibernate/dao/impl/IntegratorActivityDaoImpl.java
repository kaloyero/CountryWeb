package com.country.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.IntegratorActivityDao;
import com.country.hibernate.model.IntegranteActividades;

@Repository("integratorActivityDao")
public class IntegratorActivityDaoImpl extends GenericDaoImpl<IntegranteActividades, Integer> implements IntegratorActivityDao{

	@Override
	protected Class<IntegranteActividades> getEntityClass() {
		return IntegranteActividades.class;
	}
	
	public IntegranteActividades findByActivityUser (int activityId, int userId){
	  	  Criteria criteria = getSession().createCriteria(getEntityClass());
	  	  criteria.add(Restrictions.eq("actividad", activityId));
	  	  criteria.add(Restrictions.eq("integrante", userId));
	 
	      return (IntegranteActividades) criteria.uniqueResult();
			
	}
}
