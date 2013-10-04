package com.country.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.form.RecursoForm;
import com.country.form.ResumenForm;
import com.country.services.ActivityManager;
import com.country.services.EventIntegratorManager;
import com.country.services.EventManager;
import com.country.services.InfractionManager;
import com.country.services.IntegratorActivityManager;
import com.country.services.MessageManager;
import com.country.services.NotificationManager;
import com.country.services.ReserveManager;
import com.country.services.ResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/calendario")
public class CalendarioController {
	@Autowired
	private ResourceManager recursoManager;
	
	
	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public @ResponseBody RecursoForm showCalendario(ModelMap model, HttpServletRequest request) {

		RecursoForm form = recursoManager.getResourceForm(1);
		//Eventos de la persona en la semana (En realidad,a medida que pase el calendario ,deberia mostarle lo que viene,o sea,aca por parametro,vamos a recibir
		 //algun tipo de fecha desde /hasta para parametrizar la busqueda
		//Recursos reservados por la persona en la semana
		//actividades de la persona
		model.addAttribute("RECURSO", form);
		
		return form;
	}

}
