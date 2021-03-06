package com.country.mappers;


import com.country.HelperCountry;
import com.country.common.DateUtil;
import com.country.form.ActividadReservaForm;
import com.country.form.CronogramaForm;
import com.country.hibernate.model.Actividad;
import com.country.hibernate.model.Cronograma;

public class ActividadReservaMapper {

	public static ActividadReservaForm  getForm(Actividad actividad){
		
		ActividadReservaForm form = new ActividadReservaForm();
		form.setNombre(actividad.getNombre());
		form.setId(actividad.getId());
		form.setDescripcion(actividad.getDescripcion());
		
		
		for (Cronograma cronograma : actividad.getCronogramas()) {
			CronogramaForm cronogramaForm = new CronogramaForm();
			cronogramaForm.setId(cronograma.getId());
			cronogramaForm.setHorario(DateUtil.setHourInfForm(cronograma.getHoraInicio()));
			cronogramaForm.setDia(HelperCountry.getDiaSemana(cronograma.getDiaSemana()));
			form.getCronograma().add(cronogramaForm);
		}
	
        	
		return form;
		
	}

	/*public static IntegranteActividad getActividadReserva(ActividadReservaForm actividadForm)
			throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date convertedDate = (Date) formatter.parse(actividadForm
				.getFechaInicio());

		// Actividad General
		IntegranteActividad integranteActividad= new IntegranteActividad();
	

		return integranteActividad;

	}*/

}
