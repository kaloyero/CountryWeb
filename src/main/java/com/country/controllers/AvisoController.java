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

import com.country.form.NoticiaForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Noticia;
import com.country.services.NewsCategoryManager;
import com.country.services.NewsManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/aviso")
public class AvisoController {

	@Autowired

	private NewsManager newsManager;
	
	@Autowired
	private NewsCategoryManager newsCategoryManager;
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		NoticiaForm noticia = new NoticiaForm();
		
		model.addAttribute("NOTICIA", noticia);
		model.addAttribute("categorias", newsCategoryManager.listAll());
		
		return "noticia";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "NOTICIA") NoticiaForm form,
			BindingResult result) throws ParseException {
		
		
		
		newsManager.save(form);
		return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		NoticiaForm form = newsManager.findFormById(id);
		
		model.addAttribute("categorias", newsCategoryManager.listAll());
		model.addAttribute("NOTICIA", form);
		
		return "forms/noticiaForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "NOTICIA") NoticiaForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		//newsManager.update(form);
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Noticia noticia : newsManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(noticia.getId()));
				row.add(noticia.getTitulo());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("5");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
