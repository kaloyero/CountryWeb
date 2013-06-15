package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.common.GenericDao;
import com.country.hibernate.dao.NewsDao;
import com.country.hibernate.model.Noticia;
import com.country.services.NewsManager;

@Service("newsManager")
public class NewsManagerImpl extends AbstractManagerImpl<Noticia> implements NewsManager{

	@Autowired
    private NewsDao newsDao;
	
	protected GenericDao<Noticia, Integer> getDao() {
		return newsDao;
	}

	public Noticia findById(Integer id) {
		Noticia dto = newsDao.findById(id);
		return dto;
	}

}
