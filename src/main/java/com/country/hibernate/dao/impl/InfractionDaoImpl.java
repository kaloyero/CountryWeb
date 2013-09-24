package com.country.hibernate.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.InfractionDao;
import com.country.hibernate.model.Infraccion;

@Repository("infractionDao")
public class InfractionDaoImpl extends GenericDaoImpl<Infraccion, Integer> implements InfractionDao{

	@Override
	protected Class<Infraccion> getEntityClass() {
		return Infraccion.class;
	}

    public void update(Infraccion infraccion) {
    	  getSession().update(infraccion);
      }

    @Transactional
    public Integer getNumInfraccionesByUnidad(int idUnidad){
        DetachedCriteria criteria = createDetachedCriteria();
        criteria.add(Restrictions.eq("unidad.id", idUnidad));
        return (Integer) criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();
    }

}
