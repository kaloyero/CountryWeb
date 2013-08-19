package com.country.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.form.EventoIntegranteForm;
import com.country.mappers.EventoIntegranteMapper;
import com.country.services.EventIntegratorManager;

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
