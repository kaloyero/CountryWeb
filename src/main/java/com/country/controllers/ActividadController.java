package com.country.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.form.ActividadForm;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Cronograma;
import com.country.hibernate.model.Instructor;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.ActividadMapper;
import com.country.services.ActivityManager;
import com.country.services.InstructorManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/actividad")
public class ActividadController {
	

	@Autowired
	private ActivityManager activityManager;
	@Autowired
	private InstructorManager instructorManager;
    
	/**
	 * Simply selects the home view to render by returning its name.
	 */


	public ActivityManager getActivityManager() {
		return activityManager;
	}

	public InstructorManager getInstructorManager() {
		return instructorManager;
	}

	public void setInstructorManager(InstructorManager instructorManager) {
		this.instructorManager = instructorManager;
	}

	public void setActivityManager(ActivityManager activityManager) {
		this.activityManager = activityManager;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		ActividadForm actividad = new ActividadForm();
		actividad.getInstructores().add(2);
		model.addAttribute("ACTIVIDAD", actividad);
		model.addAttribute("instructores", instructorManager.listAll());		
		return "actividad";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm,
			BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			return "registration";
		} else {
			
			activityManager.save(ActividadMapper.getActividad(actividadForm,instructorManager));
			System.out.println("GRABAaa " );
			return "success";
		}
	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String showActidiad(@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm{
//		Actividad activivad =actividadManager.findbyid(id)
//		ActividadForm actividadForm =new ActividadForm(actividad)
//		actividadForm.setNombre(actividad.setNombre)
//		
//		///Recorrer lista cronograma
//		 for (Cronograma cronograma: actividad.getCronogramas()) {
//			 
//			 
//			//Dependpenid la dia del cronograma
//			 switch case cronograma.getDiaSemana()
//			 
//			  "Lunes" actividadForm.getLunes().add(cronograma.getHoraInicio())
//			  "Martes" 
//			
//		 }
//		model.addAttirubte ("ACtividad ",actividadForm)
//		   
//		
//	}


	
}
