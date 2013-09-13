package com.country.mappers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.country.form.Form;
import com.country.form.RecursoForm;
import com.country.hibernate.model.Concepto;
import com.country.hibernate.model.Recurso;
import com.country.hibernate.model.RecursoDisponibilidad;
import com.country.hibernate.model.Tarifa;
import com.country.hibernate.model.TipoRecurso;

public class RecursoMapper {

	public static Recurso getRecurso(Form form) {
		
		Recurso recurso = new Recurso();
		recurso.setId(((RecursoForm) form).getId());
		recurso.setDescripcion(((RecursoForm) form).getDescripcion());
		recurso.setNombre(((RecursoForm) form).getNombre());
		recurso.setMaxTiempoReserv(((RecursoForm) form).getMaxTiempoReserva());
		TipoRecurso tipoRecurso =new TipoRecurso();
		tipoRecurso.setId(((RecursoForm) form).getTipoRecurso());
		recurso.setTipoRecurso(tipoRecurso);
		
		recurso.setConcepto(getConcepto((RecursoForm)form));
		return recurso;

	}
	
	public static List <RecursoDisponibilidad> getRecursoDisponibilidad(Form form) {

		   List <RecursoDisponibilidad> disponibilidades = new ArrayList<RecursoDisponibilidad>();
			
			try {

				JSONArray json = (JSONArray)new JSONParser().parse(((RecursoForm) form).getDisponibilidades());
				Iterator it = 	json.iterator();
			        while( it.hasNext() ){
			        	JSONObject nodo = (JSONObject)it.next();
			        	RecursoDisponibilidad disponibilidad =new RecursoDisponibilidad();
			        	disponibilidad.setDiaSemana(((Long) nodo.get("Dia")).intValue());
			        	disponibilidad.setHoraIni(((Long) nodo.get("horaIni")).intValue());
			        	disponibilidad.setHoraFin(((Long) nodo.get("horaFin")).intValue());
			        	disponibilidad.setRecurso(((RecursoForm) form).getId());
			        	disponibilidades.add(disponibilidad);
			         
			        }		

			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return disponibilidades;

	}

	public static RecursoForm getForm(Recurso recurso, double tarifa,List<RecursoDisponibilidad> listDispoRec) {
		RecursoForm form=new RecursoForm();
		form.setId(recurso.getId());
		form.setNombre(recurso.getNombre());
		form.setDescripcion(recurso.getDescripcion());
		form.setIdConcepto(recurso.getConcepto().getId());
		form.setImporte(tarifa);
		form.setTipoRecurso(recurso.getTipoRecurso().getId());
		form.setTipoRecursoDesc(recurso.getTipoRecurso().getNombre());
		form.setMaxTiempoReserva(recurso.getMaxTiempoReserv());

		form.setDisponibilidades(getDisponibilidades(listDispoRec));
	
	
		return form;
	}
	
	public static String getDisponibilidades (List<RecursoDisponibilidad> disponibilidades){
		JSONArray raizDisponibilidades = new JSONArray();
		if (disponibilidades!=null)
			for (RecursoDisponibilidad disponibilidad :disponibilidades) {
				
				for(int i=disponibilidad.getHoraIni(); i<disponibilidad.getHoraFin(); i++) {
					JSONObject nodoDisp=new JSONObject();
					nodoDisp.put("dia",disponibilidad.getDiaSemana());
					nodoDisp.put("horaIni",i);
					nodoDisp.put("horaFin",i+1);
					raizDisponibilidades.add(nodoDisp);
				}
				
			}
		
		
		
//		
//		JSONObject obj=new JSONObject();
//		  obj.put("name","foo");
//		  obj.put("num",new Integer(100));
//		  obj.put("balance",new Double(1000.21));
//		  obj.put("is_vip",new Boolean(true));
//		  obj.put("nickname",null);
//		  JSONObject obj2=new JSONObject();
//		  obj2.put("name","foo");
//		  obj2.put("num",new Integer(100));
//		  obj2.put("balance",new Double(1000.21));
//		  obj2.put("is_vip",new Boolean(true));
//		  obj2.put("nickname",null);
//		  
//		  JSONArray users = new JSONArray();
//		  users.add(obj);
//		  users.add(obj2);
		  
		  
		  
		  
		  StringWriter out = new StringWriter();
		  try {
			  raizDisponibilidades.writeJSONString(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return  out.toString();
		
	}
	

	public static Concepto getConcepto (RecursoForm form){
		Concepto concepto = new Concepto();
		concepto.setId(form.getIdConcepto());
		concepto.setNombre(form.getNombre());
		concepto.setFechaComienzo(new Date(2012, 12, 12));
		return concepto;
		
	}
	
	public static List<Tarifa> getTarifa (RecursoForm form,Concepto concepto){
		List<Tarifa> tarifas = new ArrayList<Tarifa>();

		Tarifa tarifa = new Tarifa();
		tarifa.setImporte(form.getImporte());
		tarifa.setFechaComienzo(new Date(2012, 12, 12));
		tarifa.setConcepto(concepto.getId());
		tarifas.add(tarifa);
		return tarifas;
		
	}

}
