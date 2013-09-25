package com.country.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.model.Actividad;

@Repository("activityDao")
public class ActivityDaoImpl extends GenericDaoImpl<Actividad, Integer> implements ActivityDao{

	@Override
	protected Class<Actividad> getEntityClass() {
		return Actividad.class;
	}
	
    public void update(Actividad obj) {
    	getSession().update(obj);
    }
	
    @SuppressWarnings("unchecked")
	@Transactional
    public Collection<Integer> getActividadVigentes(){
    	Collection<Integer> list = new ArrayList<Integer>();
    	DetachedCriteria criteria = createDetachedCriteria();
        criteria.setProjection(Projections.property("id"));
        //TODO agregar campo Estado para obtener solo las actividades activas.
        //criteria.add(Restrictions.ge("fecha", date));
        list = (Collection<Integer>) criteria.getExecutableCriteria(getSession()).list();
		if (list.size() == 0){
			list.add(0);
		}
		return list;
    }
    
}
