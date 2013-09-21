package com.country.controllers;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.country.common.DateUtil;
import com.country.form.ReservaForm;
import com.country.hibernate.model.Reserva;
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
			  ReservaForm form,
			  HttpServletRequest request
			) throws ParseException {
	
		reservaManager.save(form);
			return "success";
	
			
	}
	//@RequestMapping(value = "/diasOcupadosa", method = RequestMethod.GET)
	@RequestMapping(value = "diasOcupados/{id}", method = RequestMethod.GET)
	public @ResponseBody String getReservasByRecurso(ModelMap model,@PathVariable int id)  {
			
		String diasOcupados="[";
		List<Reserva> listaActividadesForm =reservaManager.findListReservationByResource(id);
		
		
		for (Reserva reserva :listaActividadesForm) {
			
			
			Calendar fechaComienzo = Calendar.getInstance(); // locale-specific
			fechaComienzo.setTime(reserva.getFecha());
			fechaComienzo.set(Calendar.HOUR_OF_DAY, reserva.getHoraIni());
			fechaComienzo.set(Calendar.MINUTE, 0);
			fechaComienzo.set(Calendar.SECOND, 0);
			fechaComienzo.set(Calendar.MILLISECOND, 0);
			//La hora hasta es la horainicio + la duracion
			Integer horaHasta=(reserva.getHoraIni() + reserva.getDuracion());
			
			Calendar fechaFin = Calendar.getInstance(); // locale-specific
			fechaFin.setTime(reserva.getFecha());
			fechaFin.set(Calendar.HOUR_OF_DAY, horaHasta);
			fechaFin.set(Calendar.MINUTE, 0);
			fechaFin.set(Calendar.SECOND, 0);
			fechaFin.set(Calendar.MILLISECOND, 0);
			diasOcupados+="{\"title\":\"Test\",\"start\":\""+DateUtil.convertDateToStringWithMinutes(fechaComienzo.getTime())+"\",\"end\":\""+DateUtil.convertDateToStringWithMinutes(fechaFin.getTime())+"\",\"url\":null,\"id\":1},";

			}
		if (!listaActividadesForm.isEmpty()){
			//Remuevo el ultimo caracter seria un "," ,que quedo en el ultimo elemento
			diasOcupados = diasOcupados.substring(0, diasOcupados.length()-1);
		}
		
		diasOcupados+="]";
		
		return diasOcupados;

			
	}
}
