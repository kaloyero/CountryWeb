package com.country.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.form.ActividadForm;
import com.country.hibernate.dao.ActivityDao;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.User;
import com.country.services.ActivityManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/actividad")
public class ActividadController {
	

	@Autowired
	private ActivityManager activityManager;
    
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
/*	public String home(Locale locale, Model model,HttpServletResponse res) {
		model.addAttribute("prueba", "puta" );
		System.out.println(res);
		res.setContentType("application/Json");
		List<String> strList = new ArrayList<String>();  
	    strList.add("Test1");strList.add("Test2");
	    strList.add("Test3");  
	    model.addAttribute("lista",strList);  
	    
	    
	    
	    
	    Actividad row = new Actividad();
		row.setId(1);
		row.setNombre("Futbol");
		row.setFechaFin(new Date(2012,12,12));
		row.setFechaComienzo(new Date(2012,12,12));
		Concepto concepto = new Concepto();
		concepto.setId(12);
		concepto.setNombre("concepto");
		concepto.setFechaComienzo(new Date(2012,12,12));
		row.setConcepto(concepto);
		activityManager.createActivity(row);
	    

	    
	    
		return "actividad";
	}*/

	public ActivityManager getActivityManager() {
		return activityManager;
	}

	public void setActivityManager(ActivityManager activityManager) {
		this.activityManager = activityManager;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		ActividadForm actividad = new ActividadForm();
		model.addAttribute("ACTIVIDAD", actividad);
		return "actividad";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm,
			BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			return "registration";
		} else {
			System.out.println("Actividad values is : " + actividadForm.getName());
			System.out.println("Actividad values2 is : " + actividadForm.getFechaInicio());
			String yyyyMMdd = "20110914";
			DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	        Date convertedDate = (Date) formatter.parse(yyyyMMdd);

			Actividad actividad = new Actividad();
			actividad.setId(3);
			actividad.setDescripcion(actividadForm.getDescripcion());
			actividad.setNombre(actividadForm.getName());
			actividad.setFechaFin(convertedDate);
			actividad.setFechaComienzo(new Date(2012,12,12));
			Concepto concepto = new Concepto();
			concepto.setId(12);
			concepto.setNombre(actividadForm.getNameCosto());
			concepto.setFechaComienzo(new Date(2012,12,12));
			actividad.setConcepto(concepto);
			activityManager.createActivity(actividad);
			return "success";
		}
	}


	
}
