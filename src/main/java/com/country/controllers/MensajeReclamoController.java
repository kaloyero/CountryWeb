package com.country.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.country.services.MessageCategoryManager;
import com.country.services.MessageManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/mensajeReclamo")
public class MensajeReclamoController {

	@Autowired
	private MessageManager messageManager;
	
	@Autowired
	private MessageCategoryManager messageCategoryManager;
		
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {
		MensajeForm mensaje = new MensajeForm();
		
		model.addAttribute("MENSAJE", mensaje);
		
		model.addAttribute("categorias", messageCategoryManager.listAll());
		//TODO Lo comentado abajo esta en mensaje,pero no en reclamo,porque??
		//model.addAttribute("integrantes", integratorManager.getIntegratorNames());
		HttpSession session = request.getSession(true);
		String usuarioConectado = (String) session.getAttribute("TipoDeUsuario");
		 if (usuarioConectado.equals("Admin")){
			 return "mensajeReclamo";
		 }else{
			 return "Propietario/mensajeForm";
		 }
		
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
		//Seteo el TIPO de mensaje como RECLAMO
		form.setTipo(TipoMensajes.TYPE_MESSAGE_RECLAMO);
		messageManager.update(form);
		
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
	
	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public String  showMessageList(ModelMap model) {

		
		List<Mensaje> mensajes =messageManager.listAll();
		model.addAttribute("mensajes", mensajes);
		
		
		return "Propietario/listadoMensajes";	
		
	}

	@RequestMapping(value = "/listaPropietarioFromUsuario",method = RequestMethod.GET)
	public String showMyMessages(ModelMap model) {
		return this.showMessageList(model);
	}

}
