package com.country.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.country.hibernate.model.Noticia;
import com.country.services.ConceptManager;
import com.country.services.MessageDetailManager;
import com.country.services.MessageManager;
import com.country.services.NewsManager;
import com.country.services.PriceManager;
import com.country.services.ResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/resumen")
public class ResumenController {


	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public String showResumen(ModelMap model, HttpServletRequest request) {
		
		return "Propietario/resumen";
	}

}
