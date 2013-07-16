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

import com.country.form.EventoForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Evento;
import com.country.services.EventManager;
import com.country.services.IntegratorManager;
import com.country.services.ResourceManager;

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
	@Autowired
	private ResourceManager recursoManager;


	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public String showMainContent(ModelMap model,HttpServletRequest request) {
		System.out.println("VALOR "+ request.getRequestURL().toString());
		List<Evento> eventos =eventManager.listAll();
		model.addAttribute("eventos", eventos);
		
		
		return "Propietario/listadoEventos";
	}
	
	@RequestMapping(value = "/listaPropietarioFromUsuario",method = RequestMethod.GET)
	public String getListaEventosByUser(ModelMap model,HttpServletRequest request) {
		System.out.println("VALOR "+ request.getRequestURL().toString());
		System.out.println("VALOR "+ request.getLocalAddr().toString());
		
		List<Evento> eventos =eventManager.listAll();
		model.addAttribute("eventos", eventos);
		
		
		return "Propietario/listadoEventos";
	}
	
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String usuarioConectado = (String) session.getAttribute("TipoDeUsuario");

		EventoForm evento = new EventoForm();
		model.addAttribute("EVENTO", evento);
		model.addAttribute("recursos", recursoManager.listAllResourceForm());
			  
		if (usuarioConectado.equals("Admin")){
			model.addAttribute("integrantes", integratorManager.getIntegratorNames());
			return "evento";
		}else{
			return "forms/eventoForm";
		}
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "EVENTO") EventoForm form,
			BindingResult result) throws ParseException {
		//TODO sirve saber si la creacion viene de Admin o propietario?
		eventManager.save(form);
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id,HttpServletRequest request) throws ParseException {
		HttpSession session = request.getSession(true);
		String usuarioConectado = (String) session.getAttribute("TipoDeUsuario");

		
		EventoForm form = eventManager.findFormById(id);
		model.addAttribute("EVENTO", form);
		model.addAttribute("recursos", recursoManager.listAllResourceForm());
		
		if (usuarioConectado.equals("Admin")){
			model.addAttribute("integrantes", integratorManager.getIntegratorNames());
			return "forms/eventoForm";
		}else{
			return "Propietario/eventoForm";
		}
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "EVENTO") EventoForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		
		eventManager.update(form);
		return "success";
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON(HttpServletRequest request)  {
           
           DataTable dataTable=new DataTable();

			for (Evento tipo : eventManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
				row.add(tipo.getDescription());
				row.add(tipo.getConcepto().getNombre());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
