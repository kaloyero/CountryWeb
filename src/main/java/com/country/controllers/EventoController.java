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

import com.country.common.Constants;
import com.country.common.SessionUtil;
import com.country.form.EventoForm;
import com.country.form.IntegranteForm;
import com.country.hibernate.model.DataTable;
import com.country.services.EventIntegratorManager;
import com.country.services.EventManager;
import com.country.services.InfractionManager;
import com.country.services.IntegratorActivityManager;
import com.country.services.IntegratorManager;
import com.country.services.MessageManager;
import com.country.services.NotificationManager;
import com.country.services.ReserveManager;
import com.country.services.ResourceManager;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/evento")
public class EventoController {

	@Autowired
	private EventManager eventManager;
	@Autowired
	private IntegratorManager integratorManager;
	@Autowired
	private ResourceManager recursoManager;
	@Autowired
	private EventIntegratorManager eventIntegratorManager;
	
	//TODO borarr solo para prueba
	@Autowired
	private IntegratorActivityManager integratorActivityManager;
	@Autowired
	private ReserveManager reserveManager;
	@Autowired
	private MessageManager messageManager;
	@Autowired
	private InfractionManager infractionManager;
	@Autowired
	private NotificationManager notificationManager;

	

	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public String showMainContent(ModelMap model,HttpServletRequest request) {
		System.out.println("VALOR "+ request.getRequestURL().toString());
		

		List<EventoForm> listaEventoForm = eventManager.listAllForms();

		for (EventoForm eventoDto : listaEventoForm) {
			// EventoForm eventoDto=(EventoForm) EventoMapper.getForm(evento,null);
			 List<IntegranteForm> test =eventIntegratorManager.findAllIntegrantorFormByEventoId(eventoDto.getId());
			 eventoDto.setCantidadUnidos(test.size());
		}
		

		
		model.addAttribute("eventos", listaEventoForm);
		
		return "Propietario/listadoEventos";
	}
	
	@RequestMapping(value = "/listaPropietarioFromUsuario",method = RequestMethod.GET)
	public String getListaEventosByUser(ModelMap model,HttpServletRequest request) {
		System.out.println("VALOR "+ request.getRequestURL().toString());
		System.out.println("VALOR "+ request.getLocalAddr().toString());
		
		return showMainContent(model,request);
	}
	@RequestMapping(value = "/eventozara",method = RequestMethod.GET)
	public String getEventoUser(ModelMap model,HttpServletRequest request) {
		System.out.println("Cantidad de eventos "+ eventManager.getEventCreatedByPerson());
		System.out.println("Cantidad de eventos inscriptos "+ eventManager.getEventoInscriptoByIntegrante());
		System.out.println("Cantidad de Actividades Inscriptas por integrante "+ integratorActivityManager.getNumActividadInscriptoByIntegrator());
		System.out.println("Cantidad de Actividades Inscriptas por Unidad "+ integratorActivityManager.getNumActividadInscriptoByIntegrator());
		System.out.println("Cantidad de Reservas por Integrante "+ reserveManager.getReserveNumByPerson());
		System.out.println("Cantidad de Reservas por unidad"+ reserveManager.getReserveNumByUnit());
		System.out.println("Cantidad de Reclamos abiertos "+ messageManager.getNumReclamosAbiertos());
		System.out.println("Cantidad de reclamos cerrados"+ messageManager.getNumReclamosCerrados());
		System.out.println("Cantidad de Infracciones por unidad"+ infractionManager.getNumInfraccionesByUnidad());
		System.out.println("Cantidad de Avisos "+ notificationManager.getNumAvisosByPerson());
		
		return "";
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpServletRequest request) {

		EventoForm evento = new EventoForm();
		//Seteo el cupo minimo TODO setear cupo minimo
		evento.setCupo(1);
		model.addAttribute("EVENTO", evento);
		model.addAttribute("recursos", recursoManager.listAllResourceForm());
			  
		if (SessionUtil.isAdminUser()){
			model.addAttribute("integrantes", integratorManager.getIntegratorNamesPersonIdKey());
			return "evento";
		}else{
			return "Propietario/eventoForm";
		}
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute(value = "EVENTO") EventoForm form,
		BindingResult result,HttpServletRequest request)  throws ParseException {
		
		if (SessionUtil.isAdminUser()){
			//En el caso de Admin Setea el nombre del concepto
			if (((EventoForm) form).getConcepto() != null){
				((EventoForm) form).getConcepto().setNombre(((EventoForm) form).getNombre());
			}
		} 
		eventManager.save(form);
				return "success";
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public String load(ModelMap model,@PathVariable int id,HttpServletRequest request) throws ParseException {
		
		EventoForm form = eventManager.findFormById(id);
		model.addAttribute("EVENTO", form);
		model.addAttribute("recursos", recursoManager.listAllResourceForm());
		
		if (SessionUtil.isAdminUser()){
			model.addAttribute("integrantes", integratorManager.getIntegratorNamesPersonIdKey());
			return "forms/eventoForm";
		}else{
			return "Propietario/eventoForm";
		}
		
	}
	
	@RequestMapping(value = "/load/{id}", method = RequestMethod.POST)
	public String update(@ModelAttribute(value = "EVENTO") EventoForm form,@PathVariable int id,
			BindingResult result) throws ParseException {
		
		eventManager.update(form);
		return "success";
	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public  @ResponseBody DataTable getUserInJSON(HttpServletRequest request)  {
           
           DataTable dataTable=new DataTable();

			for (EventoForm tipo : eventManager.listAllForms()) {
				List <String> row =new ArrayList<String>();
				row.add(String.valueOf(tipo.getId()));
				row.add(tipo.getNombre());
				if (Constants.PERSONA_EMPLEADO.equals(tipo.getPersona().getTipo()) ){
					row.add("ADMINISTRADOR (" + tipo.getPersona().getNombre() + " " + tipo.getPersona().getApellido()+ ")");
				} else {
					row.add(tipo.getPersona().getNombre() + " " + tipo.getPersona().getApellido());	
				}
				if (tipo.getConcepto() != null){
					row.add(String.valueOf(tipo.getConcepto().getImporte()));
				} else {
					row.add("0");
				}
				
				row.add("Dia " + tipo.getFecha() + " a las " + tipo.getHourIni() + " (duracion "+ tipo.getDuracion() +" hs) ");
				row.add(String.valueOf(tipo.getCupo()));
				row.add(String.valueOf(tipo.getCantidadUnidos()));
				row.add("Aprobado");
				row.add("");
				dataTable.getAaData().add(row);
			}

           dataTable.setsEcho("1");
           dataTable.setiTotalDisplayRecords("2");
           dataTable.setiTotalRecords("1");
           return dataTable;
	}

}
