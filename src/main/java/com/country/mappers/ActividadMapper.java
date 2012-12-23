package com.country.mappers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.country.form.ActividadForm;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Asignacion;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Cronograma;
import com.country.hibernate.model.Tarifa;
import com.country.services.InstructorManager;
import com.country.services.impl.InstructorManagerImpl;

public class ActividadMapper {

////	private static InstructorManager instructorManager =new InstructorManagerImpl();
////
////	public static InstructorManager getInstructorManager() {
////		return instructorManager;
////	}
//
//	public void setInstructorManager(InstructorManager instructorManager) {
//		instructorManager = instructorManager;
//	}

	public static Actividad getActividad(ActividadForm actividadForm,InstructorManager instructorManager)
			throws ParseException {
		System.out.println("Actividad values is : " + actividadForm.getName());
		System.out.println("Actividad values2 is : "
				+ actividadForm.getFechaInicio());
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date convertedDate = (Date) formatter.parse(actividadForm
				.getFechaInicio());

		// Actividad General
		Actividad actividad = new Actividad();
		actividad.setDescripcion(actividadForm.getDescripcion());
		actividad.setNombre(actividadForm.getName());
		actividad.setFechaFin(convertedDate);
		actividad.setFechaComienzo(new Date(2012, 12, 12));

		//Listas
		actividad.setAsignaciones(getAsignaciones(actividadForm,actividad,instructorManager));
		actividad.setCronogramas(getCronogramas(actividadForm,actividad));
		actividad.setConcepto(getConcepto(actividadForm));

		return actividad;

	}
	
	public static List getAsignaciones (ActividadForm actividadForm,Actividad actividad,InstructorManager instructorManager){
		// Profesores
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
	
	public static List getCronogramas (ActividadForm actividadForm,Actividad actividad){
		List<Cronograma> cronogramas = new ArrayList<Cronograma>();
		Iterator it = actividadForm.getDias().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry cronogramaEleccion = (Map.Entry) it.next();
			for (String horas : (String[]) cronogramaEleccion.getValue()) {
				String[] tokens = horas
						.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

				for (String hora : tokens) {
					Cronograma cronograma = new Cronograma();
					cronograma.setActividad(actividad);
					cronograma.setDiaSemana((Integer) cronogramaEleccion.getKey());
					cronograma.setHoraInicio(Integer.parseInt(hora));
					cronogramas.add(cronograma);
					System.out.println(cronogramaEleccion.getKey() + " = " + hora);
				}

			}
			it.remove();
		}
		return cronogramas;
		
	}
	
	public static Concepto getConcepto (ActividadForm actividadForm){
		Concepto concepto = new Concepto();
		concepto.setNombre(actividadForm.getName());
		concepto.setFechaComienzo(new Date(2012, 12, 12));
		concepto.setTarifas(getTarifa(actividadForm,concepto));
		return concepto;
		
	}
	
	public static List getTarifa (ActividadForm actividadForm,Concepto concepto){
		Tarifa tarifa = new Tarifa();
		tarifa.setImporte(actividadForm.getImporte());
		tarifa.setFechaComienzo(new Date(2012, 12, 12));
		tarifa.setConcepto(concepto);
		List<Tarifa> tarifas = new ArrayList<Tarifa>();
		tarifas.add(tarifa);
		return tarifas;
		
	}


}
