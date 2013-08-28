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

import com.country.common.DateUtil;
import com.country.common.SessionUtil;
import com.country.common.TipoMensajes;
import com.country.form.MensajeForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.MensajeDetalles;
import com.country.mappers.MensajeMapper;
import com.country.services.IntegratorManager;
import com.country.services.MessageCategoryManager;
import com.country.services.MessageDetailManager;
import com.country.services.MessageManager;
import com.country.session.UsuarioInfo;

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
		
	@Autowired
	private IntegratorManager integratorManager;
	
	@Autowired
	private MessageDetailManager messageDetailManager;


	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {
		MensajeForm mensaje = new MensajeForm();

		//Setea como la fecha por defecto la fecha actual.
		mensaje.setFecha(DateUtil.getStringToday());
		//Seteo el TIPO de mensaje como RECLAMO
		mensaje.setTipo(TipoMensajes.TYPE_MESSAGE_RECLAMO);
		
		
		model.addAttribute("MENSAJE", mensaje);
		model.addAttribute("categorias", messageCategoryManager.listAll());
		
		
		
		 if (SessionUtil.isAdminUser(request)){
			 model.addAttribute("integrantes", integratorManager.getIntegratorNames());
			 return "mensajeReclamo";
		 }else{
			 return "Propietario/mensajeForm";
		 }
		
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "MENSAJE") MensajeForm form,
			BindingResult result,HttpServletRequest request) throws ParseException {
		UsuarioInfo user = SessionUtil.getUserInfo(request);
		
		//TODO en lugar de hacer este set en el Get,se pone aca,ya que,en el caso de propietario,al no tener los campos fecha y tipo en el formulario en la UI,
		//me obliga a ponerlos como al menos invisibles,sino estos valores vuelven a estar nulos.Y se corre peligro si alguien inspecciona el codigo html y le 
		//cambia el tipo de relcamo a M o otra cosa
		
		//Setea como la fecha por defecto la fecha actual.
		form.setFecha(DateUtil.getStringToday());
		//Seteo el TIPO de mensaje como RECLAMO
		form.setTipo(TipoMensajes.TYPE_MESSAGE_RECLAMO);

			 messageManager.save(form,user);
		
		return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id,HttpServletRequest request) throws ParseException {
		MensajeForm form = messageManager.findFormById(id);

		model.addAttribute("categorias", messageCategoryManager.listAll());
		model.addAttribute("MENSAJE", form);

		 if (SessionUtil.isAdminUser(request)){
			 model.addAttribute("mensajes", messageDetailManager.getDetailsByMessajeId(id));
			 return "forms/mensajeReclamoForm";
		 }else{
			 return "forms/mensajeReclamoForm";
		 }
		
		

	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "MENSAJE") MensajeForm form,@PathVariable int id,
			BindingResult result,HttpServletRequest request) throws ParseException {
		UsuarioInfo user = SessionUtil.getUserInfo(request);	
		if (SessionUtil.isAdminUser(request)){
			 form.setAccion(TipoMensajes.STATUS_OUT);
		 }else{
			 form.setAccion(TipoMensajes.STATUS_IN);
		 }

		messageManager.update(form,user);
		
		return "success";
		

	}
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON()  {
           
			DataTable dataTable=new DataTable();

			for (MensajeForm obj : messageManager.listAllForms(TipoMensajes.TYPE_MESSAGE_RECLAMO)) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(obj.getId()));
				row.add(obj.getAsunto());
				if ( obj.isEnvio()){
					row.add("Administrador (" + obj.getEmpleadoNombre()+")");
					row.add(obj.getIntegranteNombre() + " " + obj.getIntegranteApellido());
				} else {
					row.add(obj.getIntegranteNombre() + " " + obj.getIntegranteApellido());
					row.add("Administrador");
				}
				row.add(obj.getCategoriaDescripcion());
				row.add(obj.getFecha());
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
		List<MensajeForm> listaReclamos = new ArrayList<MensajeForm>();
		
		for (Mensaje mensaje : messageManager.getMessajesCategoryType(TipoMensajes.TYPE_MESSAGE_RECLAMO)) {
			 MensajeForm mensajeDto=(MensajeForm) MensajeMapper.getForm(mensaje);
			 mensajeDto.setTipo(TipoMensajes.TYPE_MESSAGE_RECLAMO);
			 MensajeDetalles mensa=messageDetailManager.getFirstDetailMessage(mensajeDto.getId());
			 mensajeDto.setDescripcion(mensa.getMensajeDetalle());
			 listaReclamos.add(mensajeDto);
		}
		
		model.addAttribute("mensajes", listaReclamos);
		
		
		return "Propietario/listadoMensajes";	
		
	}

	@RequestMapping(value = "/listaPropietarioFromUsuario",method = RequestMethod.GET)
	public String showMyMessages(ModelMap model) {
		return this.showMessageList(model);
	}

}
