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

import com.country.form.AvisoForm;
import com.country.hibernate.model.Aviso;
import com.country.hibernate.model.DataTable;
import com.country.services.NotificationManager;
import com.country.services.NotificationSuscriptionManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/aviso")
public class AvisoController {

	@Autowired

	private NotificationManager notificationManager;
	
	@Autowired
	private NotificationSuscriptionManager notificationSuscriptionManager;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		AvisoForm aviso = new AvisoForm();
		
		model.addAttribute("AVISO", aviso);
		model.addAttribute("categorias", notificationSuscriptionManager.listAll());
		
		return "aviso";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "AVISO") AvisoForm form,
			BindingResult result) throws ParseException {
		
		notificationManager.save(form);
		
		return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		AvisoForm form = notificationManager.findFormById(id);
		
		model.addAttribute("categorias", notificationSuscriptionManager.listAll());
		model.addAttribute("AVISO", form);
		
		return "forms/avisoForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "Aviso") AvisoForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		notificationManager.update(form);
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Aviso aviso: notificationManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(aviso.getId()));
				row.add(aviso.getTittle());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("5");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
