package com.country.services;

import java.util.List;

import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.EventoIntegrante;

public interface EventIntegratorManager extends AbstractManager<EventoIntegrante>{

	List<EventoForm> findAllEventByIntegratorId(Integer id);
	
	List<IntegranteForm> findAllIntegrantorFormByEventoId(Integer id);
	
}
