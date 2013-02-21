package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.services.AbstractManager;

public abstract class AbstractManagerImpl<E> implements AbstractManager<E> { 
	
	protected abstract GenericDao<E, ?> getDao();
	
	@Transactional
	public void save(E dto) {
		getDao().save(dto);
	}

	@Transactional
	public void update(E dto) {
		getDao().update(dto);
	}	

	
	@Transactional
	public void delete(E persistentObject) {
		getDao().delete(persistentObject);
    }

//	@Transactional
//	public E findById(PK id) {
//		E dto = getDao().findById(id);
//		return dto;
//	}
	
	@Transactional
	public List<E> listAll() {
		List<E> list = new ArrayList<E>();
		list = getDao().findAll();
		return list;
	}
	
}
