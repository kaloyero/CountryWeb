package com.country.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.VehicleDao;
import com.country.hibernate.model.IntegranteActividades;
import com.country.hibernate.model.Vehiculo;

@Repository("vehicleDao")
public class VehicleDaoImpl extends GenericDaoImpl<Vehiculo, Integer> implements VehicleDao{

	@Override
	protected Class<Vehiculo> getEntityClass() {
		return Vehiculo.class;
	}

    public void update(Vehiculo obj) {
  	  getSession().update(obj);
  }
	@Transactional
	public IntegranteActividades findByActivityUser (int activityId, int userId){
	  	  Criteria criteria = getSession().createCriteria(getEntityClass());
	  	  criteria.add(Restrictions.eq("actividad", activityId));
	  	  criteria.add(Restrictions.eq("integrante", userId));
	 
	      return (IntegranteActividades) criteria.uniqueResult();
			
	}
	@Transactional
	public List<Vehiculo> findVehiclesByUnidad(int unidadId) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
	  	criteria.add(Restrictions.eq("unidad.id", unidadId));
	  	return  criteria.list();
	}

	
	
}
