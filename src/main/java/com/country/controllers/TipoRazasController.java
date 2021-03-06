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

import com.country.form.TipoRazaForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Raza;
import com.country.mappers.TipoMapper;
import com.country.services.EspecieManager;
import com.country.services.RazaManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoRaza")
public class TipoRazasController {

	@Autowired
	private RazaManager razaManager;

	@Autowired
	private EspecieManager especieManager;
	
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		TipoRazaForm tipo = new TipoRazaForm();
		model.addAttribute("TIPO", tipo);
		model.addAttribute("accion", "tipoRaza");
		model.addAttribute("especies", especieManager.listAll());

		return "tipoRaza";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "TIPO") TipoRazaForm tipoForm,
			BindingResult result) throws ParseException {
		
		razaManager.save(TipoMapper.getTipoRaza(tipoForm));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		Raza type =razaManager.findById(id);
		TipoRazaForm form = (TipoRazaForm) TipoMapper.getForm(type);
		model.addAttribute("TIPO", form);
		model.addAttribute("especies", especieManager.listAll());
		
		return "forms/tipoRazaForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "TIPO") TipoRazaForm tipoForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		razaManager.update(TipoMapper.getTipoRaza(tipoForm));
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Raza tipo : razaManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
				row.add(String.valueOf(tipo.getId()));
				row.add(tipo.getNombre());
				row.add(tipo.getEspecie().getNombre());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
