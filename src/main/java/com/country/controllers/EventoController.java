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

import com.country.form.EventoForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Evento;
import com.country.mappers.EventoMapper;
import com.country.services.EventManager;
import com.country.services.IntegratorManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/evento")
public class EventoController {

	@Autowired
	private EventManager eventManager;
	
	@Autowired
	private IntegratorManager integratorManager;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		EventoForm evento = new EventoForm();
		model.addAttribute("EVENTO", evento);
		model.addAttribute("integrantes", integratorManager.getIntegratorNames());
		
		return "evento";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "EVENTO") EventoForm form,
			BindingResult result) throws ParseException {
		
		eventManager.save(EventoMapper.getEvento(form));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		EventoForm form = eventManager.findFormById(id);
		model.addAttribute("EVENTO", form);
		model.addAttribute("integrantes", integratorManager.getIntegratorNames());

		return "forms/eventoForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "EVENTO") EventoForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		eventManager.update(EventoMapper.getEvento(form));
		return "success";
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Evento tipo : eventManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
				row.add(tipo.getDescription());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
