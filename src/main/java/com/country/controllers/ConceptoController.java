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

import com.country.form.ConceptoForm;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Tarifa;
import com.country.mappers.ConceptoMapper;
import com.country.services.ConceptManager;
import com.country.services.PriceManager;
import com.country.services.ResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/concepto")
public class ConceptoController {

	@Autowired
	private ConceptManager conceptManager;
	
	@Autowired
	private ResourceManager recursoManager;
	
	@Autowired
    private PriceManager priceManager;


	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		ConceptoForm form = new ConceptoForm();
		model.addAttribute("CONCEPTO", form);
		for (Recurso recurso : recursoManager.listAll()) {
			System.out.println("Prueba");
		}
		return "concepto";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "CONCEPTO") ConceptoForm form,
			BindingResult result) throws ParseException {
		
		if (result.hasErrors()) {
			return "registration";
		} else {
			conceptManager.save(ConceptoMapper.getConcepto(form),form.getImporte());
			return "success";
		}
			
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
		Concepto concepto =conceptManager.findById(id);
		Tarifa tarifa = priceManager.getLastPriceByConcept(concepto.getId());
		
		ConceptoForm form = (ConceptoForm) ConceptoMapper.getForm(concepto,tarifa);
		model.addAttribute("CONCEPTO", form);
		
		return "forms/conceptoForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "INTEGRANTE") ConceptoForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		conceptManager.update(ConceptoMapper.getConcepto(form),form.getImporte());
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();
           
			for (Concepto concepto : conceptManager.listAll()) {
				List <String> row =new ArrayList<String>();
				Tarifa tarifa = priceManager.getLastPriceByConcept(concepto.getId());
				row.add(String.valueOf(concepto.getId()));
				row.add(String.valueOf(concepto.getNombre()));
				row.add(String.valueOf(concepto.getFechaComienzo()));
				if (tarifa != null){
					row.add(String.valueOf(tarifa.getImporte()));	
				} else {
					row.add("0.00");
				}
				row.add(concepto.getNombre());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("4");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
