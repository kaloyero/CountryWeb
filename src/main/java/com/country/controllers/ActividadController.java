package com.country.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.form.ActividadForm;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.DataTable;
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


	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		ActividadForm actividad = new ActividadForm();
		model.addAttribute("ACTIVIDAD", actividad);
		model.addAttribute("instructores", instructorManager.listAll());
		return "actividad";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm,
			BindingResult result) throws ParseException {
		
		if (result.hasErrors()) {
			return "registration";
		} else {
//			actividadForm.setId(10);
			activityManager.save(ActividadMapper.getActividad(actividadForm,
					instructorManager));
			return "success";
		}
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
		Actividad actividad =activityManager.findById(id);
		ActividadForm form = (ActividadForm) ActividadMapper.getForm(actividad);
		model.addAttribute("ACTIVIDAD", form);
		model.addAttribute("instructores", instructorManager.listAll());
		return "forms/actividadForm";

	}
	
	//TODO no deberia llamar directamente al metodo Crear?
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			return "registration";
		} else {
			activityManager.update(ActividadMapper.getActividad(actividadForm,instructorManager));
			return "success";
		}

	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Actividad actividad : activityManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(actividad.getId()));
				row.add(actividad.getNombre());
				row.add(actividad.getDescripcion());
				dataTable.getAaData().add(row);
			};
			dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
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
