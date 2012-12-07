package com.country.common;

import java.io.Serializable;
import java.util.List;

import com.country.beans.Property;

public interface GenericDao<E,PK  extends Serializable> {
    PK save(E newInstance);
    
    void update(E transientObject);
    
    void saveOrUpdate(E transientObject);
    
    void delete(E persistentObject);
    
    E findById(PK id);
    
    List<E> findAll();
    
    List<E> findAllByProperty(String propertyName,Object value);
    
    List<E> listByPropertiesPagin(int pagIni,int qtRows, List<Property> properties, String searchText,String orderByProperty, boolean asc);
  	
    List<E> findByPagin(int pagIni,int qtRows, String orderByProperty, boolean asc);
    
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,Map<String, ?> params) throws DataAccessException;
//  	
//    <T> List<T> findByNamedParam(Class<T> entityClass, 
//  			String query,String[] paramNames, Object[] values) throws DataAccessException;
}