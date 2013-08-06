package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.NoticiaForm;
import com.country.hibernate.dao.NewsDao;
import com.country.hibernate.model.Noticia;
import com.country.hibernate.model.NoticiaAdjunto;
import com.country.mappers.NoticiaMapper;
import com.country.services.NewsAttachManager;
import com.country.services.NewsManager;

@Service("newsManager")
public class NewsManagerImpl extends AbstractManagerImpl<Noticia> implements
		NewsManager {

	@Autowired
	private NewsDao newsDao;

	@Autowired
	private NewsAttachManager newsAttachManager;

	protected GenericDao<Noticia, Integer> getDao() {
		return newsDao;
	}

	@Transactional
	private Noticia findById(Integer id) {
		Noticia dto = newsDao.findById(id);
		dto.getAdjuntos().size();
		return dto;
	}

	@Transactional
	public NoticiaForm findFormById(Integer id) {

		NoticiaForm form = NoticiaMapper.getForm(findById(id));
		return form;
	}

	@Transactional
	public int save(NoticiaForm form) {
		Noticia dto = NoticiaMapper.getNoticia(form);
		
		getDao().save(dto);

		// Guardo los adjuntos
		for (NoticiaAdjunto adjunto : dto.getAdjuntos()) {
			adjunto.setNoticia(dto.getId());
			newsAttachManager.save(adjunto);
		}

		return dto.getId();
	}
	
	@Transactional
	public int update(NoticiaForm form) {
		Noticia dto = NoticiaMapper.getNoticia(form);
		
		getDao().update(dto);

		// Guardo los adjuntos TODO ver que onda
		for (NoticiaAdjunto adjunto : dto.getAdjuntos()) {
			adjunto.setNoticia(dto.getId());
			newsAttachManager.save(adjunto);
		}

		return dto.getId();
	}
	

}
