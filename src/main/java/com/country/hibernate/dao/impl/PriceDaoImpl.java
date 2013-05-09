package com.country.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.PriceDao;
import com.country.hibernate.model.Tarifa;

@Repository("priceDao")
public class PriceDaoImpl extends GenericDaoImpl<Tarifa, Integer> implements PriceDao{

	@Override
	protected Class<Tarifa> getEntityClass() {
		return Tarifa.class;
	}
	
    public void update(Tarifa obj) {
    	getSession().update(obj);
    }
	
    public Tarifa getLastPriceByConcept(int concept) {
  	  Criteria criteria = getSession().createCriteria(getEntityClass());
  	  criteria.add(Restrictions.like("concepto", concept));
  	  criteria.addOrder(Order.desc("id"));
  	  criteria.setMaxResults(1);
 
      return (Tarifa) criteria.uniqueResult();
    }

    
}
