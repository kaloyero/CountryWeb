package com.country.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.common.TipoMensajes;
import com.country.form.MensajeForm;
import com.country.form.RecursoForm;
import com.country.form.ReservaForm;
import com.country.hibernate.model.DataTable;
import com.country.hibernate.model.Mensaje;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.Reserva;
import com.country.mappers.RecursoMapper;
import com.country.mappers.ReserveMapper;
import com.country.services.MessageCategoryManager;
import com.country.services.MessageManager;
import com.country.services.ReserveManager;
import com.country.services.ResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/recursoReserva")
public class RecursoReservaController {
	
	@Autowired
	private ReserveManager reservaManager;
	@Autowired
	private ResourceManager recursoManager;
	
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	//TODO investigar bien como puedo usar el bindResult aca.Si no le agrego el model atribute tira error,y si le agrego el model attribute,no me
	//llega la data en formatoJson
	public String processJson(@RequestBody
			  ReservaForm form
			) throws ParseException {
		//TODO porque en Set Evento ,me pide un objecto evento y en set Integrante,solamente el Id del integrante y no un objeto Integrante?
			
		reservaManager.save(ReserveMapper.getReserva(form));
			return "success";
		//}
			
	}

}
