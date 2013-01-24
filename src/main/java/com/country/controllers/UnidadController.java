package com.country.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import com.country.form.InstructorForm;
import com.country.form.UnidadForm;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Instructor;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.Unidad;

import com.country.mappers.ActividadMapper;
import com.country.mappers.InstructorMapper;
import com.country.mappers.UnidadMapper;
import com.country.services.ActivityManager;
import com.country.services.InstructorManager;
import com.country.services.UnitManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/unidad")
public class UnidadController {

	@Autowired
	private UnitManager unidadManager;


	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		UnidadForm unidad = new UnidadForm();
		model.addAttribute("UNIDAD", unidad);
		
		return "unidad";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "UNIDAD") UnidadForm unidadForm,
			BindingResult result) throws ParseException {
		
		unidadManager.save(UnidadMapper.getUnidad(unidadForm));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		return "forms/unidadForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm,@PathVariable int id,
			BindingResult result) throws ParseException {
				return null;
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Unidad unidad : unidadManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(unidad.getId()));
				row.add(unidad.getCode());
				dataTable.getAaData().add(row);
			}
 ;
           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}