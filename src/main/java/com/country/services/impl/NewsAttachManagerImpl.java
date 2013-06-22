package com.country.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.hibernate.dao.NewsAttachDao;
import com.country.hibernate.model.NoticiaAdjunto;
import com.country.services.NewsAttachManager;

@Service("newsAttachManager")
public class NewsAttachManagerImpl extends AbstractManagerImpl<NoticiaAdjunto> implements NewsAttachManager{

	@Autowired
    private NewsAttachDao newsAttachDao;
	
	protected GenericDao<NoticiaAdjunto, Integer> getDao() {
		return newsAttachDao;
	}

	@Transactional
	public NoticiaAdjunto findById(Integer id) {
		NoticiaAdjunto dto = newsAttachDao.findById(id);
		return dto;
	}

}
