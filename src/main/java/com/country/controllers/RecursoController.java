package com.country.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.form.RecursoForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Recurso;
import com.country.mappers.RecursoMapper;
import com.country.services.ResourceManager;
import com.country.services.TypeResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/recurso")
public class RecursoController {

	@Autowired
	private ResourceManager recursoManager;

	@Autowired
	private TypeResourceManager tipoResourceManager;



	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		RecursoForm form = new RecursoForm();
		model.addAttribute("tipoRecurso", tipoResourceManager.listAll());
		model.addAttribute("RECURSO", form);

		return "recurso";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "RECURSO") RecursoForm form,
			BindingResult result) throws ParseException {
		
		if (result.hasErrors()) {
			return "registration";
		} else {
			
	    recursoManager.save(form);
			return "success";
		}
			
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
		RecursoForm form = recursoManager.getResourceForm(id);
		
		model.addAttribute("tipoRecurso", tipoResourceManager.listAll());
		model.addAttribute("RECURSO", form);
		return "forms/recursoForm";
	}
	
	@RequestMapping(value = "recursosParaReservar/load/{id}", method = RequestMethod.GET)
	public @ResponseBody RecursoForm loadDisponibilidadByRecurso(ModelMap model,@PathVariable int id) throws ParseException {
		RecursoForm form = recursoManager.getResourceForm(id);

		model.addAttribute("RECURSO", form);
		
		return form;

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "RECURSO") RecursoForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		if (result.hasErrors()) {
			return "registration";
		} else {
			recursoManager.update(form);
			return "success";
		}
	}
	
	
	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public String showActivitiesForBook(ModelMap model) {
		
		List<RecursoForm> listaRecursosForm = recursoManager.listAllForms();

		//for (Recurso recurso : recursoManager.listAllForms()) {
			//listaRecursosForm.add(RecursoMapper.getForm(recurso,0,null));
		//}
		
		
		model.addAttribute("recursos", listaRecursosForm);
		
	
		return "Propietario/recursosReserva";
		
	}
	

	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
            DataTable dataTable=new DataTable();
   		    System.out.println("Entrandoo!!  ");

			for (Recurso recurso : recursoManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(recurso.getId()));
				row.add(recurso.getNombre());
				row.add(recurso.getConcepto().getNombre());
				row.add(recurso.getTipoRecurso().getNombre());
				
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}
	@RequestMapping(value = "/diasOcupados", method = RequestMethod.GET)
	public  @ResponseBody String getDiasOcupados()  {
		
	String test="[{\"title\":\"Test\",\"start\":\"2013-07-21T08:00:00\",\"end\":\"2013-07-21T09:00:00\",\"url\":null,\"id\":1}]";
	return test;
}

}
