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

import com.country.form.InfraccionForm;
import com.country.hibernate.model.DataTable;
import com.country.services.InfractionManager;
import com.country.services.TypeInfractionManager;
import com.country.services.UnitManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/infraccion")
public class InfraccionController {

	@Autowired
	private InfractionManager infractionManager;
	
	@Autowired
	private TypeInfractionManager typeInfractionManager;

	@Autowired
	private UnitManager unitManager;

	
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {
		InfraccionForm form = new InfraccionForm();

		
		model.addAttribute("unidades", unitManager.listAll());
		model.addAttribute("categorias", typeInfractionManager.listAll());
		model.addAttribute("INFRACCION", form);
		return "infraccion";
		
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "INFRACCION") InfraccionForm form,
			BindingResult result,HttpServletRequest request) throws ParseException {
		
		infractionManager.save(form);
		
		return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id,HttpServletRequest request) throws ParseException {
		InfraccionForm form = infractionManager.findFormById(id);

		model.addAttribute("categorias", typeInfractionManager.listAll());
		model.addAttribute("INFRACCION", form);

		return "forms/infraccionForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "INFRACCION") InfraccionForm form,@PathVariable int id,
			BindingResult result,HttpServletRequest request) throws ParseException {

		infractionManager.update(form);
		
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
			DataTable dataTable=new DataTable();

			for (InfraccionForm obj : infractionManager.listAllForms()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(obj.getId()));
				row.add(obj.getNumero());
				row.add(obj.getFecha());
				row.add(obj.getImporte());
				row.add(obj.getTipoInfraccion().getNombre());
				row.add(obj.getUnidadDesc());
				row.add("");
				dataTable.getAaData().add(row);
			}

			dataTable.setsEcho("1");
			dataTable.setiTotalDisplayRecords("5");
			dataTable.setiTotalRecords("1");
			return dataTable;
	}


}
