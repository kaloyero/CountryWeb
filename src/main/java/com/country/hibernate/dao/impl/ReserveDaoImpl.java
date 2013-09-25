package com.country.hibernate.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.dao.ReserveDao;
import com.country.hibernate.model.Reserva;

@Repository("reserveDao")
public class ReserveDaoImpl extends GenericDaoImpl<Reserva, Integer> implements ReserveDao{

	@Autowired
	private IntegratorDao integratorDao;
	
	@Override
	protected Class<Reserva> getEntityClass() {
		return Reserva.class;
	}

	public Reserva findResourceAfterBefore(boolean AfterBefore,
			Integer resource, Date fecha, int horaIni) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("recurso", resource));
		
		if (AfterBefore){
			//After
			//mayor igual a la fecha
			criteria.add(Restrictions.ge("fecha", fecha));
			criteria.add(Restrictions.ge("horaIni", horaIni));
			criteria.addOrder(Order.asc("fecha"));
			criteria.addOrder(Order.asc("horaIni"));
		} else {
			//Before
			//menor a la fecha
			criteria.add(Restrictions.lt("fecha", fecha));
			criteria.add(Restrictions.lt("horaIni", horaIni));
			criteria.addOrder(Order.desc("fecha"));
			criteria.addOrder(Order.desc("horaIni"));
		}
		criteria.setMaxResults(1);
		 
		return (Reserva) criteria.uniqueResult();

	}

	@Transactional
	public Integer getReserveNumByPerson(int idPerson, Date date) {
	        DetachedCriteria criteria = createDetachedCriteria();
	        criteria.add(Restrictions.eq("persona", idPerson));
	        criteria.add(Restrictions.ge("fecha", date));
	        return (Integer) criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();
	}

	@Transactional
	public Integer getReserveNumByUnit(int idUnit, Date date) {
		//TODO rehacer query. Refactorizar el IN
        DetachedCriteria criteria = createDetachedCriteria();
	    criteria.add(Restrictions.in("persona", integratorDao.getIntegPersonNumByUnit(idUnit)));
	    criteria.add(Restrictions.ge("fecha", date));
	  	return (Integer) criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();	
	}


}
