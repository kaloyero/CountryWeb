package com.country.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ActividadController {
	

	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/actividad", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletResponse res) {
		model.addAttribute("prueba", "puta" );
		System.out.println(res);
		res.setContentType("application/Json");
		List<String> strList = new ArrayList<String>();  
	    strList.add("Test1");strList.add("Test2");
	    strList.add("Test3");  
	    model.addAttribute("lista",strList);  
		return "actividad";
	}


	
}
