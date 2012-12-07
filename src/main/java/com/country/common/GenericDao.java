package com.country.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GenericDao<E,PK  extends Serializable> {
    PK save(E newInstance);
    
    void update(E transientObject);
    
    void saveOrUpdate(E transientObject);
    
    void delete(E persistentObject);
    
    E findById(PK id);
    
    List<E> findAll();
    
    List<E> findAllByProperty(String propertyName,Object value);
  	
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,Map<String, ?> params) throws DataAccessException;
//  	
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,String[] paramNames, Object[] values) throws DataAccessException;
}