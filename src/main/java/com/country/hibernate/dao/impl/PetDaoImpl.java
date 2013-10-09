package com.country.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.PetDao;
import com.country.hibernate.model.Mascota;

@Repository("petDao")
public class PetDaoImpl extends GenericDaoImpl<Mascota, Integer> implements PetDao{

	@Override
	protected Class<Mascota> getEntityClass() {
		return Mascota.class;
	}

    public void update(Mascota obj) {
    	  getSession().update(obj);
    }

	public List<Mascota> findMascotassByUnidad(Integer unidadId) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
	  	criteria.add(Restrictions.eq("unidad.id", unidadId));
	  	return  criteria.list();
	}

}
