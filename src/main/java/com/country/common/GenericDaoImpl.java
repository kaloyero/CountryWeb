package com.country.common;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.country.beans.Property;

//public abstract class GenericDaoImpl<E, PK extends Serializable> extends
//            HibernateDaoSupport implements GenericDao<E, PK> {
      
public abstract class GenericDaoImpl<E, PK extends Serializable> implements GenericDao<E, PK> {


	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
    protected abstract Class<E> getEntityClass();
    
    protected DetachedCriteria createDetachedCriteria() {
          return DetachedCriteria.forClass(getEntityClass());
    }
    
    protected Session getSession(){
  	  return sessionFactory.getCurrentSession();
    }
	
	
	  @SuppressWarnings("unchecked")
	  public PK save(E newInstance) {
		  return (PK) getSession().save(newInstance);
      }

      public void update(E transientObject) {
    	  //getSession().merge(transientObject);
    	  getSession().update(transientObject);
      }

      public void saveOrUpdate(E transientObject) {
    	  getSession().merge(transientObject);
    	  getSession().saveOrUpdate(transientObject);
//    	  getSession().flush();
      }

      public void delete(E persistentObject) {
    	  getSession().delete(persistentObject);
      }

      @SuppressWarnings("unchecked")
      public E findById(PK id) {
            return (E) getSession().get(getEntityClass(), id);
      }
      
      @SuppressWarnings("unchecked")
      public List<E> findAll() {
//          DetachedCriteria criteria = createDetachedCriteria();
//          return (List<E>) criteria.getExecutableCriteria(getSession()).list();
    	  
    	  Criteria criteria = getSession().createCriteria(getEntityClass());
    	  return (List<E>) criteria.list();
      }
      
      /**
       * @param pagIni
       * @param qtRows
       * @param orderByProperty
       * @param asc Si es true orderBy asc.
       * @return
       */
      @SuppressWarnings("unchecked")
      public List<E> findByPagin(int pagIni,int qtRows, String orderByProperty, boolean asc) {
    	  Criteria criteria = getSession().createCriteria(getEntityClass());
    	  criteria.setFirstResult(pagIni);
    	  criteria.setMaxResults(qtRows);
    	  if (StringUtils.isNotBlank(orderByProperty)){
    	  	if (asc){
    	  		criteria.addOrder(Order.asc(orderByProperty));		
    	  	} else {
    	  		criteria.addOrder(Order.desc(orderByProperty));
    	  	}
    	  }
    	  
          return (List<E>) criteria.list();
      }

    @SuppressWarnings("unchecked")
    public List<E> listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc) {
    	Criteria criteria = getSession().createCriteria(getEntityClass());
    	criteria.setFirstResult(pagIni);
    	criteria.setMaxResults(qtRows);
    	for (Property property : properties) {
    		if (Property.TYPE_CADENA.equals(property.getType()) ){
    			criteria.add(Restrictions.like(property.getName(), "%"+searchText+"%"));	
    		}
		}
    	  if (StringUtils.isNotBlank(orderByProperty)){
			  	if (asc){
			  		criteria.addOrder(Order.asc(orderByProperty));		
			  	} else {
			  		criteria.addOrder(Order.desc(orderByProperty));
			  	}
			  }
          return (List<E>) criteria.list();
    }
      
      
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<E> findAllByProperty(String propertyName, Object value) {
            DetachedCriteria criteria = createDetachedCriteria();
            criteria.add(Restrictions.eq(propertyName, value));
            return (List<E>) criteria.getExecutableCriteria(getSession()).list();
      }
      
      
//  	@SuppressWarnings("unchecked")
//  	public <T> List<T> findByNamedParam(Class<T> entityClass, String query,
//  			String[] paramNames, Object[] values) throws DataAccessException {
//  		
//  		List<T> results = (List<T>) getSession().findByNamedParam(query, paramNames, values);
//  		return results;
//  		
//  	}

//  	@SuppressWarnings("unchecked")
//  	public <T> List<T> findByNamedParam(Class<T> entityClass, String query,
//  			Map<String, ?> params) throws DataAccessException {
//  		
//  		String[] paramNames = new String[params.size()];
//  		Object[] values = new Object[params.size()];
//  		
//  		List<String> keys = new ArrayList<String>(params.keySet());
//  		for(int i=0; i<keys.size(); i++){
//  			String k = keys.get(i);
//  			paramNames[i] = k;
//  			values[i] = params.get(k);
//  		}
//  		
//  		List<T> results = (List<T>) getSession().findByNamedParam(query, paramNames, values);
//  		return results;
//  		
//  	}
  	
//  	protected T findByCriteria(Criteria cirit){
//    	Criteria crit = getSession().createCriteria(entityClass);
//    	return T result = (T) crit.uniqueResult();
//  	}
 
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}