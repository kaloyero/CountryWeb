package com.country.controllers;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.hibernate.model.Evento;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.country.hibernate.model.Noticia;
import com.country.services.ConceptManager;
import com.country.services.EventManager;
import com.country.services.MessageDetailManager;
import com.country.services.MessageManager;
import com.country.services.NewsManager;
import com.country.services.PriceManager;
import com.country.services.ResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/evento")
public class EventoController {

	@Autowired
	private EventManager eventoManager;


	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public String showMainContent(ModelMap model) {

		List<Evento> eventos =eventoManager.listAll();
		model.addAttribute("eventos", eventos);
		
		
		return "Propietario/listadoEventos";
	}

}
