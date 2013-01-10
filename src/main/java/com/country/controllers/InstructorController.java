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
import com.country.form.InstructorForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Instructor;
import com.country.mappers.InstructorMapper;
import com.country.services.InstructorManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/instructor")
public class InstructorController {

	@Autowired
	private InstructorManager instructorManager;


	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		InstructorForm instructor = new InstructorForm();
		model.addAttribute("INSTRUCTOR", instructor);
		
		return "instructor";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "INSTRUCTOR") InstructorForm instructorForm,
			BindingResult result) throws ParseException {
		
		instructorManager.save(InstructorMapper.getInstructor(instructorForm));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		return "forms/actividadForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "ACTIVIDAD") ActividadForm actividadForm,@PathVariable int id,
			BindingResult result) throws ParseException {
				return null;
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Instructor actividad : instructorManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(actividad.getId()));
				row.add(actividad.getPersona().getApellido());
				row.add(actividad.getPersona().getNombre());
				dataTable.getAaData().add(row);
			}
 ;
           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
