package com.country.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.common.DateUtil;
import com.country.form.AvisoCategoriaForm;
import com.country.hibernate.model.AvisoCategoria;
import com.country.hibernate.model.DataTable;
import com.country.services.NotificationCategoryManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/avisoCategoria")
public class AvisoCategoriaController {

	@Autowired
	private NotificationCategoryManager notificationCategoryManager;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		AvisoCategoriaForm tipo = new AvisoCategoriaForm();
		model.addAttribute("TIPO", tipo);
		model.addAttribute("accion", "avisoCategoria");
		
		return "avisoCategoria";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "TIPO") AvisoCategoriaForm form,
			BindingResult result) throws ParseException {
		
		form.setFechaIni(DateUtil.getStringToday());
		
		notificationCategoryManager.save(form);
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id,HttpServletRequest request) throws ParseException {
	
		AvisoCategoriaForm form = notificationCategoryManager.findFormById(id);
		model.addAttribute("TIPO", form);

		return "forms/avisoCategoriaForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "TIPO") AvisoCategoriaForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		notificationCategoryManager.update(form);
		return "success";
		

	}

	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON(HttpServletRequest request)  {
           
           DataTable dataTable=new DataTable();

			for (AvisoCategoria tipo : notificationCategoryManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
				row.add(tipo.getNombre());
				row.add(tipo.getConcepto().getDescripcion());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
