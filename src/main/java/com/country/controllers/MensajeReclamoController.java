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

import com.country.common.TipoMensajes;
import com.country.form.MensajeForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Mensaje;
import com.country.services.MessageManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/mensajeReclamo")
public class MensajeReclamoController {

	@Autowired
	private MessageManager messageManager;
		
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		MensajeForm mensaje = new MensajeForm();
		
		model.addAttribute("MENSAJE", mensaje);
		
		return "mensajeReclamo";
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "MENSAJE") MensajeForm form,
			BindingResult result) throws ParseException {
		
		//Seteo el TIPO de mensaje como RECLAMO
		form.setTipo(TipoMensajes.TYPE_MESSAGE_RECLAMO);
		
		messageManager.save(form);
		
		return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		MensajeForm form = messageManager.findFormById(id);

		model.addAttribute("MENSAJE", form);
		
		return "forms/mensajeReclamoForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "MENSAJE") MensajeForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		//TODO update mensaje
		//newsManager.update(integranteForm);
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
			DataTable dataTable=new DataTable();

			for (Mensaje obj : messageManager.getMessajesCategoryType(TipoMensajes.TYPE_MESSAGE_RECLAMO)) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(obj.getId()));
				row.add(obj.getAsunto());
				row.add(obj.getEstado());
				dataTable.getAaData().add(row);
			}

			dataTable.setsEcho("1");
			dataTable.setiTotalDisplayRecords("5");
			dataTable.setiTotalRecords("1");
			return dataTable;
	}

}
