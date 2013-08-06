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

import com.country.form.TipoVacunaForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.TipoVacuna;
import com.country.mappers.TipoMapper;
import com.country.services.EspecieManager;
import com.country.services.TypeVacunaManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoVacuna")
public class TipoVacunasController {

	@Autowired
	private TypeVacunaManager typeVacunaManager;
	
	@Autowired
	private EspecieManager especieManager;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		TipoVacunaForm tipo = new TipoVacunaForm();

		//Inicializando formulario
		tipo.setObligatoria(false);
		tipo.setVigencia(0);
		
		model.addAttribute("TIPO", tipo);
		model.addAttribute("especies", especieManager.listAll());
		model.addAttribute("accion", "tipoVacuna");
		return "tipoVacuna";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "TIPO") TipoVacunaForm tipoForm,
			BindingResult result) throws ParseException {
		
		typeVacunaManager.save(TipoMapper.getTipoVacuna(tipoForm));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		TipoVacuna type =typeVacunaManager.findById(id);
		TipoVacunaForm form = (TipoVacunaForm) TipoMapper.getForm(type);
		model.addAttribute("TIPO", form);
		model.addAttribute("especies", especieManager.listAll());

		return "forms/tipoVacunaForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "TIPO") TipoVacunaForm tipoForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		typeVacunaManager.update(TipoMapper.getTipoVacuna(tipoForm));
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (TipoVacuna tipo : typeVacunaManager.listAll()) {
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
