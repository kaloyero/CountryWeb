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

import com.country.form.MensajeForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Mensaje;
import com.country.mappers.MensajeMapper;
import com.country.services.IntegratorManager;
import com.country.services.MessageCategoryManager;
import com.country.services.MessageDetailManager;
import com.country.services.MessageManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/mensaje")
public class MensajeController {

	@Autowired
	private MessageManager messageManager;
	
	@Autowired
	private MessageCategoryManager messageCategoryManager;
	
	@Autowired
	private IntegratorManager integratorManager;
	
	
	@Autowired
	private MessageDetailManager messageDetailManager;

	
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {
		//Preguntar en sesion si es un Admin o propietario
		MensajeForm mensaje = new MensajeForm();
		model.addAttribute("MENSAJE", mensaje);
		model.addAttribute("categorias", messageCategoryManager.listAll());
		model.addAttribute("integrantes", integratorManager.getIntegratorNames());
		HttpSession session = request.getSession(true);
		String usuarioConectado = (String) session.getAttribute("TipoDeUsuario");
		 if (usuarioConectado.equals("Admin")){
			 return "mensajeForm";
		 }else{
			 return "Propietario/mensajeForm";
		 }
		

		//return "Propietario/mensajeForm";//HAbiliutar esto para que ande el alta en Prop
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "MENSAJE") MensajeForm form,
			BindingResult result) throws ParseException {

		messageManager.save(form);
	   return "success";

		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id) throws ParseException {
	
		MensajeForm form = messageManager.findFormById(id);
		model.addAttribute("MENSAJE", form);
		model.addAttribute("categorias", messageCategoryManager.listAll());
		model.addAttribute("integrantes", integratorManager.getIntegratorNames());

		return "forms/mensajeForm";

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "MENSAJE") MensajeForm tipoForm,@PathVariable int id,
			BindingResult result) throws ParseException {
		//Pasar la llamada al mapper en el manager,igual que en otros lados
		messageManager.update(MensajeMapper.getMensaje(tipoForm));
		return "success";
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
           DataTable dataTable=new DataTable();

			for (Mensaje tipo : messageManager.listAll()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
				row.add(tipo.getAsunto());
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
