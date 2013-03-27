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

import com.country.form.TipoForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.TipoDocumento;
import com.country.mappers.TipoMapper;
import com.country.services.TypeDocumentManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/tipoDocumento")
public class TipoDocumentosController {

	@Autowired
	private TypeDocumentManager typeDocumentManager;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		TipoForm tipo = new TipoForm();
		model.addAttribute("TIPO", tipo);
		model.addAttribute("accion", "tipoDocumento");
		
		return "tipoDocumento";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "TIPO") TipoForm tipoForm,
			BindingResult result) throws ParseException {
		
		typeDocumentManager.save(TipoMapper.getTipoDocumento(tipoForm));
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		TipoDocumento type =typeDocumentManager.findById(id);
		TipoForm form = (TipoForm) TipoMapper.getForm(type);
		model.addAttribute("TIPO", form);

		return "forms/tipoForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "TIPO") TipoForm tipoForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		typeDocumentManager.update(TipoMapper.getTipoDocumento(tipoForm));
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (TipoDocumento tipo : typeDocumentManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
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
