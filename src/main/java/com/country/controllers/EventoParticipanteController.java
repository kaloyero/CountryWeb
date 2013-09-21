package com.country.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.form.EventoIntegranteForm;
import com.country.services.EventIntegratorManager;
import com.country.session.SessionUsr;

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
			  EventoIntegranteForm form,
			  HttpServletRequest request
			) throws ParseException {
		
		eventIntegratorManager.inscribirseEvento(form.getEvento(),SessionUsr.User().getIntegranteId());
		return "success";

			
	}

}
