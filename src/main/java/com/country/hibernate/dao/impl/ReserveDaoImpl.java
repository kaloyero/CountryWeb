package com.country.hibernate.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ReserveDao;
import com.country.hibernate.model.Reserva;

@Repository("reserveDao")
public class ReserveDaoImpl extends GenericDaoImpl<Reserva, Integer> implements ReserveDao{

	@Override
	protected Class<Reserva> getEntityClass() {
		return Reserva.class;
	}

	public Reserva findResourceAfterBefore(boolean AfterBefore,
			Integer resource, Date fecha, int horaIni) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("recurso.id", resource));
		
		if (AfterBefore){
			//After
			//mayor igual a la fecha
			criteria.add(Restrictions.ge("fecha", fecha));
			criteria.add(Restrictions.ge("horaIni", fecha));
			criteria.addOrder(Order.asc("fecha"));
			criteria.addOrder(Order.asc("horaIni"));
		} else {
			//Before
			//menor a la fecha
			criteria.add(Restrictions.lt("fecha", fecha));
			criteria.add(Restrictions.lt("horaIni", fecha));
			criteria.addOrder(Order.desc("fecha"));
			criteria.addOrder(Order.desc("horaIni"));
		}
		criteria.setMaxResults(1);
		 
		return (Reserva) criteria.uniqueResult();

	}

}
