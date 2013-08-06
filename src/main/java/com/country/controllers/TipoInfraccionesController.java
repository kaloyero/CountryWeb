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

import com.country.common.DateUtil;
import com.country.form.TipoInfraccionForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.TipoInfraccion;
import com.country.services.TypeInfractionManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoInfraccion")
public class TipoInfraccionesController {

	@Autowired
	private TypeInfractionManager typeInfractionManager;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		TipoInfraccionForm tipo = new TipoInfraccionForm();
		model.addAttribute("TIPO", tipo);
		model.addAttribute("accion", "tipoInfraccion");		
		return "tipoInfraccion";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "TIPO") TipoInfraccionForm form,
			BindingResult result) throws ParseException {
		
		form.setFechaIni(DateUtil.getStringToday());
		
		typeInfractionManager.save(form);
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		TipoInfraccionForm form =typeInfractionManager.findByFormId(id);
		model.addAttribute("TIPO", form);
		
		return "forms/tipoInfraccionForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "TIPO") TipoInfraccionForm tipoForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		typeInfractionManager.update(tipoForm);
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (TipoInfraccion tipo : typeInfractionManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
				row.add(tipo.getNombre());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
