package com.country.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.MessageDetailDao;
import com.country.hibernate.model.MensajeDetalles;

@Repository("messageDetailDao")
public class MessageDetailDaoImpl extends GenericDaoImpl<MensajeDetalles, Integer> implements MessageDetailDao{

	@Override
	protected Class<MensajeDetalles> getEntityClass() {
		return MensajeDetalles.class;
	}

    public MensajeDetalles getLastDetailByIdMessage(int message) {
    	  Criteria criteria = getSession().createCriteria(getEntityClass());
    	  criteria.add(Restrictions.like("mensaje", message));
    	  criteria.addOrder(Order.desc("id"));
    	  criteria.setMaxResults(1);
   
        return (MensajeDetalles) criteria.uniqueResult();
      }

	
}
