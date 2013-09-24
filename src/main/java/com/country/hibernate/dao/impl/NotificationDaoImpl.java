package com.country.hibernate.dao.impl;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.NotificationDao;
import com.country.hibernate.model.Aviso;

@Repository("notificationDao")
public class NotificationDaoImpl extends GenericDaoImpl<Aviso, Integer> implements NotificationDao{

	@Override
	protected Class<Aviso> getEntityClass() {
		return Aviso.class;
	}

    @Transactional
    public Integer getNumAvisosByPerson(int idPerson,Date dateEnd){
        DetachedCriteria criteria = createDetachedCriteria();
        criteria.add(Restrictions.eq("persona.id", idPerson));
        criteria.add(Restrictions.ge("fechaFin", dateEnd));
        return (Integer) criteria.getExecutableCriteria(getSession()).setProjection(Projections.rowCount()).uniqueResult();
    }

}
