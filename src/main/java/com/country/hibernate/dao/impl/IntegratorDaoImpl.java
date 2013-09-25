package com.country.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.Constants;
import com.country.common.GenericDaoImpl;
import com.country.hibernate.dao.IntegratorDao;
import com.country.hibernate.model.Integrante;

@Repository("integratorDao")
public class IntegratorDaoImpl extends GenericDaoImpl<Integrante, Integer> implements IntegratorDao{

	@Override
	protected Class<Integrante> getEntityClass() {
		return Integrante.class;
	}
	
    public void update(Integrante integrante) {
  	  getSession().update(integrante);
    }

    @SuppressWarnings("unchecked")
	public List<Integrante> searchComboIntegrators(String searchText,boolean name,boolean surName,boolean unit,boolean document) {
    	Criteria criteria = getSession().createCriteria(getEntityClass());

    	if (surName){
    		criteria.add(Restrictions.like("persona.apellido", "%"+searchText+"%"));
    		criteria.addOrder(Order.asc("persona.apellido"));
    	}
    	if (name){
    		criteria.add(Restrictions.like("persona.nombre", "%"+searchText+"%"));
    		criteria.addOrder(Order.asc("persona.nombre"));
    	}
		if (unit){
			criteria.add(Restrictions.like("unidad.code", "%"+searchText+"%"));
			criteria.addOrder(Order.asc("unidad.code"));
		}
    	if (document){
    		criteria.add(Restrictions.like("persona.nroDoc", "%"+searchText+"%"));
    		criteria.addOrder(Order.asc("persona.nroDoc"));
    	}
    	//Me aseguro que el usuario este Activo
		criteria.add(Restrictions.like("estado", Constants.TRUE));
		
		return ((List<Integrante>) criteria.list());
    }
    

    @SuppressWarnings("unchecked")
    @Transactional
	public List<Integrante> findAll(boolean active) {
    	Criteria criteria = getSession().createCriteria(getEntityClass());
    	 if (active){
    		 criteria.add(Restrictions.like("estado", Constants.TRUE));	 
    	 } else {
    		 criteria.add(Restrictions.like("estado", Constants.FALSE));    		 
    	 }
		
		return ((List<Integrante>) criteria.list());
    }
    
    @Transactional
    public List <Integrante> getIntegratorsByUnit(int idUnit){
        return findAllByProperty("unidad.id", idUnit);
    }

    @SuppressWarnings("unchecked")
	@Transactional
    public Collection<Integer> getIntegratorsNumByUnit(int idUnit){
        DetachedCriteria criteria = createDetachedCriteria();
        criteria.setProjection(Projections.property("id"));
        criteria.add(Restrictions.eq("unidad.id", idUnit));
        return (Collection<Integer>) criteria.getExecutableCriteria(getSession()).list();
    }
    
    @SuppressWarnings("unchecked")
	@Transactional
    public Collection<Integer> getIntegPersonNumByUnit(int idUnit){
    	Collection<Integer> list = new ArrayList<Integer>();
        DetachedCriteria criteria = createDetachedCriteria();
        criteria.setProjection(Projections.property("persona.id"));
        criteria.add(Restrictions.eq("unidad.id", idUnit));
        list = (Collection<Integer>) criteria.getExecutableCriteria(getSession()).list();
		if (list.size() == 0){
			list.add(0);
		}
		return list;        

    }
}
