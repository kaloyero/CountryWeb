package com.country.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.form.ActividadForm;

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


	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		ActividadForm actividad = new ActividadForm();
		actividad.getInstructores().add(2);
		model.addAttribute("ACTIVIDAD", actividad);
		model.addAttribute("instructores", instructorManager.listAll());
		return "actividad";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm,
			BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			return "registration";
		} else {
			activityManager.save(ActividadMapper.getActividad(actividadForm,
					instructorManager));
			return "success";
		}
	}
	
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
	
	
}
