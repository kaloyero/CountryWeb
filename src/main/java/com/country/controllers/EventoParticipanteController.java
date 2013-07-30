package com.country.controllers;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.common.DateUtil;
import com.country.form.EventoIntegranteForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.model.Cronograma;
import com.country.hibernate.model.Reserva;
import com.country.mappers.EventoIntegranteMapper;
import com.country.mappers.ReserveMapper;
import com.country.services.EventIntegratorManager;
import com.country.services.ReserveManager;
import com.country.services.ResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/eventoParticipar")
public class EventoParticipanteController {
	
	@Autowired
	private EventIntegratorManager eventIntegratorManager;
	
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	//TODO investigar bien como puedo usar el bindResult aca.Si no le agrego el model atribute tira error,y si le agrego el model attribute,no me
	//llega la data en formatoJson
	public String processJson(@RequestBody
			  EventoIntegranteForm form
			) throws ParseException {
		form.setIntegrante(1);
		eventIntegratorManager.save(EventoIntegranteMapper.getEventoIntegrante(form));
		return "success";

			
	}

}
