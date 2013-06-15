package com.country.services;

import java.util.List;

import com.country.form.AvisoCategoriaForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.AvisoSuscripcion;

public interface NotificationSuscriptionManager extends AbstractManager<AvisoSuscripcion>{

	List<AvisoCategoriaForm> findAllCategoriesByIntegratorId(Integer id);
	
	List<IntegranteForm> findAllIntegrantorFormByNotificationId(Integer id);
	
}
