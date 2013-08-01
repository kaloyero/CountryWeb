package com.country.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NotificationSuscriptionDao;
import com.country.hibernate.model.AvisoSuscripcion;

@Repository("notificationSuscriptionDao")
public class NotificationSuscriptionDaoImpl extends GenericDaoImpl<AvisoSuscripcion, Integer> implements NotificationSuscriptionDao{

	@Override
	protected Class<AvisoSuscripcion> getEntityClass() {
		return AvisoSuscripcion.class;
	}

	public AvisoSuscripcion findByCategoryUser (int categoriaId, int userId){
	  	  Criteria criteria = getSession().createCriteria(getEntityClass());
	  	  criteria.add(Restrictions.eq("categoria", categoriaId));
	  	  criteria.add(Restrictions.eq("integrante", userId));
	 
	      return (AvisoSuscripcion) criteria.uniqueResult();
			
	}

}
