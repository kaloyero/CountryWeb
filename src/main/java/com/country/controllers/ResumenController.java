package com.country.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
