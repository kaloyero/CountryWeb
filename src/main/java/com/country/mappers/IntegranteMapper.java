package com.country.mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.country.form.Form;
import com.country.form.IntegranteForm;
import com.country.form.RecursoForm;
import com.country.hibernate.model.Integrante;
import com.country.hibernate.model.RecursoDisponibilidad;
import com.country.hibernate.model.Telefono;
import com.country.hibernate.model.TipoTelefono;
import com.country.hibernate.model.Unidad;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class IntegranteMapper {

	public static Integrante getIntegrante(IntegranteForm integranteForm)
			throws ParseException {

		Integrante integrante = new Integrante();
		Unidad unidad =new Unidad();
		unidad.setId(integranteForm.getUnidad());
		integrante.setId(integranteForm.getId());
		integrante.setUnidad(unidad);
		integrante.setTipo("T");
		integrante.setPersona(PersonaMapper.getPersona(integranteForm.getPersona()));
		return integrante;

	}
	
	public static IntegranteForm getForm(Integrante integrante,List<Telefono> tels)
			throws ParseException {

		IntegranteForm integranteForm=new IntegranteForm();
		integranteForm.setId(integrante.getId());
		integranteForm.setPersona(PersonaMapper.getForm(integrante.getPersona(), null, tels));
		integranteForm.setUnidad(integrante.getUnidad().getId());
		return integranteForm;

	}
	public static List <Telefono> getTelefonos(Form form) {

		   List <Telefono> telefonos = new ArrayList<Telefono>();
			
			try {

				JSONArray json = (JSONArray)new JSONParser().parse(((IntegranteForm) form).getPersona().getTelefonos());
				Iterator it = 	json.iterator();
			        while( it.hasNext() ){
			        	JSONObject nodo = (JSONObject)it.next();
			        	Telefono dto = new Telefono();

			    		//dto.setId(((TelefonoForm) form).getId());
			    		dto.setCodigoArea(((Long) nodo.get("Telefono")).intValue());
			    		dto.setCodigoPais(((Long) nodo.get("Telefono")).intValue());
			    		dto.setNumero(((Long) nodo.get("Telefono")).intValue());
			    		dto.setPrefijo(((Long) nodo.get("Telefono")).intValue());
			    		TipoTelefono tipoTel = new TipoTelefono();
			    		tipoTel.setId(1);
			    		dto.setTipoTelefono(tipoTel);
			    		telefonos.add(dto);
			         
			        }		

			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return telefonos;

	}
	
	

}
