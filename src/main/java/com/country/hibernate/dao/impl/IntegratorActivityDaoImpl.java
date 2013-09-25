package com.country.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.dao.IntegratorActivityDao;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.model.IntegranteActividades;

@Repository("integratorActivityDao")
public class IntegratorActivityDaoImpl extends GenericDaoImpl<IntegranteActividades, Integer> implements IntegratorActivityDao{

	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private IntegratorDao integratorDao;
	
	@Override
	protected Class<IntegranteActividades> getEntityClass() {
		return IntegranteActividades.class;
	}
	
	@Transactional
	public IntegranteActividades findByActivityUser (int activityId, int userId){
	  	  Criteria criteria = getSession().createCriteria(getEntityClass());
	  	  criteria.add(Restrictions.eq("actividad", activityId));
	  	  criteria.add(Restrictions.eq("integrante", userId));
	 
	      return (IntegranteActividades) criteria.uniqueResult();
			
	}
	
	@Transactional
	public Integer getNumActividadInscriptoByIntegrator (int integranteId){
		//TODO rehacer query. Refactorizar el IN
          DetachedCriteria criteria = createDetachedCriteria();
		  criteria.add(Restrictions.eq("integrante", integranteId));
	  	  criteria.add(Restrictions.in("actividad", activityDao.getActividadVigentes()));
	  	  return (Integer) criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();
			
	}
	
	@Transactional
	public Integer getNumActividadInscriptoByUnidad (int unidadId){
		//TODO rehacer query. Refactorizar el IN
          DetachedCriteria criteria = createDetachedCriteria();
		  criteria.add(Restrictions.in("integrante", integratorDao.getIntegratorsNumByUnit(unidadId)));
	  	  criteria.add(Restrictions.in("actividad", activityDao.getActividadVigentes()));
	  	  return (Integer) criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();
	}


}
