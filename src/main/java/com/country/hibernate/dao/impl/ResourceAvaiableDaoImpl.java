package com.country.hibernate.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.ResourceAvaiableDao;
import com.country.hibernate.model.RecursoDisponibilidad;

@Repository("resourceAvaiableDao")
public class ResourceAvaiableDaoImpl extends GenericDaoImpl<RecursoDisponibilidad, Integer> implements ResourceAvaiableDao{

	@Override
	protected Class<RecursoDisponibilidad> getEntityClass() {
		return RecursoDisponibilidad.class;
	}

	@SuppressWarnings("unchecked")
	public List<RecursoDisponibilidad> listDisponibilidadRecursoPorDia(
			int recurso, int dia) {

        DetachedCriteria criteria = createDetachedCriteria();
        criteria.add(Restrictions.eq("recurso", recurso));
        criteria.add(Restrictions.eq("diaSemana", dia));

        return (List<RecursoDisponibilidad>) criteria.getExecutableCriteria(getSession()).list();

	}

}
