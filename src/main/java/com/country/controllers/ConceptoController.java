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
import com.country.form.ConceptoForm;
import com.country.form.InstructorForm;
import com.country.form.IntegranteForm;
import com.country.form.UnidadForm;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Instructor;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.Persona;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Unidad;

import com.country.mappers.ActividadMapper;
import com.country.mappers.ConceptoMapper;
import com.country.mappers.InstructorMapper;
import com.country.mappers.IntegranteMapper;
import com.country.mappers.UnidadMapper;
import com.country.services.ActivityManager;
import com.country.services.ConceptManager;
import com.country.services.InstructorManager;
import com.country.services.IntegratorManager;
import com.country.services.ResourceManager;
import com.country.services.UnitManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/concepto")
public class ConceptoController {

	@Autowired
	private ConceptManager conceptoManager;
	
	@Autowired
	private ResourceManager recursoManager;
	


	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		ConceptoForm form = new ConceptoForm();
		model.addAttribute("CONCEPTO", form);
		for (Recurso recurso : recursoManager.listAll()) {
			System.out.println("Prueba");
		}
		return "concepto";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "CONCEPTO") ConceptoForm form,
			BindingResult result) throws ParseException {
		
		if (result.hasErrors()) {
			return "registration";
		} else {
			conceptoManager.save(ConceptoMapper.getConcepto(form));
			return "success";
		}
			
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
		Concepto concepto =conceptoManager.findById(id);
		
		ConceptoForm form = (ConceptoForm) ConceptoMapper.getForm(concepto);
		model.addAttribute("CONCEPTO", form);
		
		return "forms/conceptoForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "INTEGRANTE") ConceptoForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Concepto concepto : conceptoManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(concepto.getId()));
				row.add(concepto.getNombre());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
