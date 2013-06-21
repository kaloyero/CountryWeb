package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.NoticiaForm;
import com.country.hibernate.dao.NewsDao;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.Noticia;
import com.country.mappers.NoticiaMapper;
import com.country.services.NewsManager;

@Service("newsManager")
public class NewsManagerImpl extends AbstractManagerImpl<Noticia> implements NewsManager{

	@Autowired
    private NewsDao newsDao;
	
	protected GenericDao<Noticia, Integer> getDao() {
		return newsDao;
	}

	private Noticia findById(Integer id) {
		Noticia dto = newsDao.findById(id);
		return dto;
	}

	public NoticiaForm findFormById(Integer id) {
		
		NoticiaForm form = NoticiaMapper.getForm(findById(id));
		
		return form;
	}
	
	@Transactional
	public void save(NoticiaForm dto) {
		Noticia dto = NoticiaMapper.();
		
		
		getDao().save(dto);
	}


}
