package com.country.common;


import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

//public abstract class GenericDaoImpl<E, PK extends Serializable> extends
//            HibernateDaoSupport implements GenericDao<E, PK> {
      
public abstract class GenericDaoImpl<E, PK extends Serializable> implements GenericDao<E, PK> {


	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	
	  @SuppressWarnings("unchecked")
      public PK save(E newInstance) {
            return (PK) getSession().save(newInstance);
      }
      @SuppressWarnings("unchecked")
      public E findById(PK id) {
            return (E) getSession().get(getEntityClass(), id);
      }
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<E> findAll() {
            return (List<E>) createDetachedCriteria().getExecutableCriteria(getSession()).list();
      }
      @SuppressWarnings("unchecked")
      @Transactional(readOnly = true)
      public List<E> findAllByProperty(String propertyName, Object value) {
            DetachedCriteria criteria = createDetachedCriteria();
            criteria.add(Restrictions.eq(propertyName, value));
            return (List<E>) criteria.getExecutableCriteria(getSession()).list();
      }

//      @Transactional(readOnly = true)
//      public List<E> findByExample(E object) {
////            List<E> resultList = getSession().findByExample(object, 0, 1);
//            return resultList;
//      }

//      @Transactional(readOnly = true)
//      public List<E> findByExample(E object, int firstResult, int maxResults) {
//            List<E> resultList = getSession().findByExample(object,
//                        firstResult, maxResults);
//            return resultList;
//      }
      public void update(E transientObject) {
    	  getSession().update(transientObject);
      }
      public void saveOrUpdate(E transientObject) {
    	  getSession().saveOrUpdate(transientObject);
      }
      public void delete(E persistentObject) {
    	  getSession().delete(persistentObject);
      }
      
      protected abstract Class<E> getEntityClass();
      
      protected DetachedCriteria createDetachedCriteria() {
            return DetachedCriteria.forClass(getEntityClass());
      }
      
      protected Session getSession(){
    	  return sessionFactory.getCurrentSession();
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