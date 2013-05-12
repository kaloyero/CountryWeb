package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.NewsCategoryDao;
import com.country.hibernate.model.NoticiaCategorias;
import com.country.services.NewsCategoryManager;

@Service("newsCategoryManager")
public class NewsManagerImpl extends AbstractManagerImpl<NoticiaCategorias> implements NewsCategoryManager{

	@Autowired
    private NewsCategoryDao newsCategoryDao;
	
	protected GenericDao<NoticiaCategorias, Integer> getDao() {
		return newsCategoryDao;
	}

	public NoticiaCategorias findById(Integer id) {
		NoticiaCategorias dto = newsCategoryDao.findById(id);
		return dto;
	}

}
