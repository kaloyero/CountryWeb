package com.country.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.country.common.GenericDao;
import com.country.form.AvisoCategoriaForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.dao.NotificationSuscriptionDao;
import com.country.hibernate.model.AvisoSuscripcion;
import com.country.services.IntegratorManager;
import com.country.services.NotificationCategoryManager;
import com.country.services.NotificationSuscriptionManager;

@Service("notificationSuscriptionManager")
public class NotificationSuscriptionManagerImpl extends AbstractManagerImpl<AvisoSuscripcion> implements NotificationSuscriptionManager{

	@Autowired
    private NotificationSuscriptionDao notificationSuscriptionDao;

	@Autowired
    private IntegratorManager integratorManager ;

	@Autowired
    private NotificationCategoryManager notificationCategoryManager ;

	
	protected GenericDao<AvisoSuscripcion, Integer> getDao() {
		return notificationSuscriptionDao;
	}

	@Transactional
	public void save(AvisoSuscripcion dto) {
		notificationSuscriptionDao.save(dto);

	}

	@Transactional
	public void update(AvisoSuscripcion dto) {
		notificationSuscriptionDao.update(dto);
	}
	
	/**
	 * Este metodo devuelve todos los Integrantes(FORM) que estan suscriptos a el aviso categoria. 
	 * 
	 * @param id de aviso categoria
	 * @return lista de Integrantes
	 */
	public List<IntegranteForm> findAllIntegrantorFormByNotificationId(Integer id) {
		List<IntegranteForm> list = new ArrayList<IntegranteForm>();
		List<AvisoSuscripcion> searchList = new ArrayList<AvisoSuscripcion>();
		searchList = notificationSuscriptionDao.findAllByProperty("categoria", id);
		for (AvisoSuscripcion dto : searchList) {
			IntegranteForm integrante = integratorManager.findFormById(dto.getIntegrante());
			list.add(integrante);
		}
		
		return list;
	}
	
	/**
	 * Este metodo devuelve todas las aviso categorias  (FORM) que esta suscripto el integrante especifico 
	 * 
	 * @param id de Integrante
	 * @return lista de avisos categoria
	 */
	public List<AvisoCategoriaForm> findAllCategoriesByIntegratorId(Integer id) {
		List<AvisoCategoriaForm> list = new ArrayList<AvisoCategoriaForm>();
		List<AvisoSuscripcion > searchList = new ArrayList<AvisoSuscripcion >();
		searchList = notificationSuscriptionDao.findAllByProperty("categoria", id);
		for (AvisoSuscripcion dto : searchList) {
			AvisoCategoriaForm categoria = notificationCategoryManager.findFormById(dto.getCategoria());
			list.add(categoria);
			
		}
		return list;
	}
}
