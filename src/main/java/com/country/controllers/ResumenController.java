package com.country.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.country.form.ResumenForm;
import com.country.services.ActivityManager;
import com.country.services.EventManager;
import com.country.services.InfractionManager;
import com.country.services.IntegratorActivityManager;
import com.country.services.MessageManager;
import com.country.services.NotificationManager;
import com.country.services.PetManager;
import com.country.services.ReserveManager;
import com.country.services.VehicleManager;
import com.country.session.SessionUsr;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/resumen")
public class ResumenController {
	@Autowired
	private EventManager eventManager;
	@Autowired
	private IntegratorActivityManager integranteActivityManager;
	@Autowired
	private MessageManager messageManager;
	@Autowired
	private InfractionManager infractionManager;
	@Autowired
	private NotificationManager notificationManager;
	@Autowired
	private VehicleManager vehiculoManager;
	@Autowired
	private PetManager mascotaManager;
	@Autowired
	private ReserveManager reserveManager;

	
	
	@RequestMapping(value = "/listaPropietario",method = RequestMethod.GET)
	public String showResumen(ModelMap model, HttpServletRequest request) {
			ResumenForm resumenForm=new ResumenForm(

				
				eventManager.getEventCreatedByPerson(),
				eventManager.getEventoInscriptoByIntegrante(),
				reserveManager.getReserveNumByPerson(),
				reserveManager.getReserveNumByUnit(),
				messageManager.getNumReclamosAbiertos(),
				messageManager.getNumReclamosCerrados(),
				infractionManager.getNumInfraccionesByUnidad(),
				notificationManager.getNumAvisosByPerson(),
				integranteActivityManager.getNumActividadInscriptoByIntegrator(),
				integranteActivityManager.getNumActividadInscriptoByUnidad(),
				SessionUsr.User().getUnidad().getIntegrantes(),vehiculoManager.findVehicleByUnidad(SessionUsr.User().getUnidad().getId()),
				mascotaManager.findByMascotasByUnidad(SessionUsr.User().getUnidad().getId()));
		
		
		//
		
		model.addAttribute("resumen", resumenForm);
		return "Propietario/resumen";
	}

}
