package com.country.mappers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.country.form.ActividadForm;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Cronograma;
import com.country.hibernate.model.Tarifa;
import com.country.services.InstructorManager;
public class ActividadMapper {

	public static ActividadForm  getForm(Actividad object){
		
		ActividadForm form = new ActividadForm();
		form.setId(object.getId());
		form.setDescripcion(object.getDescripcion());
		form.setNombre(object.getNombre());
		//System.out.println("AFUERA ENRTA"+actividad.getAsignaciones());

		for (Asignacion asignacion : object.getAsignaciones()) {
			form.getInstructores().add(asignacion.getInstructor().getId());
		}
		//TODO se deberia tomar solo el importe reciente
	   for (Tarifa tarifa :object.getConcepto().getTarifas()) {
		   form.setImporte(tarifa.getImporte());
		}
//	   for (Tarifa tarifa :actividad.getConcepto().getTarifas()) {
//		   form.setImporte(tarifa.getImporte());
//		}
	   
	   for (Cronograma cronograma :object.getCronogramas()) {
		   form.getDias().get(cronograma.getDiaSemana()).add(Integer.toString(cronograma.getHoraInicio()));
	   }
		
		return form;
		
	}

	public static Actividad getActividad(ActividadForm actividadForm,InstructorManager instructorManager)
			throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date convertedDate = (Date) formatter.parse(actividadForm
				.getFechaInicio());

		// Actividad General
		Actividad actividad = new Actividad();
		actividad.setId(actividadForm.getId());
		actividad.setDescripcion(actividadForm.getDescripcion());
		actividad.setNombre(actividadForm.getNombre());
		actividad.setFechaFin(convertedDate);
		actividad.setFechaComienzo(new Date(2012, 12, 12));

		//Listas
		actividad.setAsignaciones(getAsignaciones(actividadForm,actividad,instructorManager));
		actividad.setConcepto(getConcepto(actividadForm));
		actividad.setCronogramas(getCronogramas(actividadForm,actividad));
		

		return actividad;

	}
	
	public static List<Asignacion> getAsignaciones (ActividadForm actividadForm,Actividad actividad,InstructorManager instructorManager){
				List<Asignacion> asignaciones = new ArrayList<Asignacion>();
				for (Integer instructor : actividadForm.getInstructores()) {
					Asignacion asignacion = new Asignacion();
					asignacion.setFechaComienzo(new Date(2012, 12, 12));
					asignacion.setInstructor(instructorManager
							.findById((Integer) instructor));
					asignacion.setActividad(actividad);
					asignaciones.add(asignacion);
				}
		return asignaciones;
		
	}
	
	public static List<Cronograma> getCronogramas (ActividadForm actividadForm,Actividad actividad){
		List<Cronograma> cronogramas = new ArrayList<Cronograma>();
		Iterator it = actividadForm.getDias().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry cronogramaEleccion = (Map.Entry) it.next();
			for (String hora : (List<String>) cronogramaEleccion.getValue()) {
			
					Cronograma cronograma = new Cronograma();
					cronograma.setActividad(actividad);
					cronograma.setDiaSemana((Integer) cronogramaEleccion.getKey());
					cronograma.setHoraInicio(Integer.parseInt(hora));	
					
					cronogramas.add(cronograma);
					System.out.println(cronogramaEleccion.getKey() + " = " + hora);

			}
			it.remove();
		}
		return cronogramas;
		
	}
	
	public static Concepto getConcepto (ActividadForm actividadForm){
		Concepto concepto = new Concepto();
		concepto.setNombre(actividadForm.getNombre());
		concepto.setFechaComienzo(new Date(2012, 12, 12));
		concepto.setTarifas(getTarifa(actividadForm,concepto));
		return concepto;
		
	}
	
	public static List<Tarifa> getTarifa (ActividadForm actividadForm,Concepto concepto){
		List<Tarifa> tarifas = new ArrayList<Tarifa>();

		Tarifa tarifa = new Tarifa();
		tarifa.setImporte(actividadForm.getImporte());
		tarifa.setFechaComienzo(new Date(2012, 12, 12));
		tarifa.setConcepto(concepto);
		tarifas.add(tarifa);
		return tarifas;
		
	}





}
