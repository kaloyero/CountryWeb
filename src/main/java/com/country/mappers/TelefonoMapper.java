package com.country.mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.country.form.Form;
import com.country.form.TelefonoForm;
import com.country.hibernate.model.Telefono;
import com.country.hibernate.model.TipoTelefono;

public class TelefonoMapper {

	public static Telefono getTelefono(Form form) {
		
		Telefono dto = new Telefono();

		dto.setId(((TelefonoForm) form).getId());
		dto.setCodigoArea(Integer.parseInt(((TelefonoForm) form).getCodigoArea()));
		dto.setCodigoPais(Integer.parseInt(((TelefonoForm) form).getCodigoPais()));
		dto.setNumero(Integer.parseInt(((TelefonoForm) form).getNumero()));
		dto.setPersona(((TelefonoForm) form).getPersona());
		dto.setPrefijo(Integer.parseInt(((TelefonoForm) form).getPrefijo()));
		TipoTelefono tipoTel = new TipoTelefono();
		tipoTel.setId(((TelefonoForm) form).getTipoTelefono());
		dto.setTipoTelefono(tipoTel);
		
		return dto;

	}
	//Devolver un telefono en base a un Json recibido
	public static Telefono getTelefono(JSONObject nodo) {
		
		Telefono dto = new Telefono();

		//dto.setId(((TelefonoForm) form).getId());
		dto.setCodigoArea(((Long) nodo.get("Telefono")).intValue());
		dto.setCodigoPais(((Long) nodo.get("Telefono")).intValue());
		dto.setNumero(((Long) nodo.get("Telefono")).intValue());
		dto.setPrefijo(((Long) nodo.get("Telefono")).intValue());
		TipoTelefono tipoTel = new TipoTelefono();
		tipoTel.setId(1);
		dto.setTipoTelefono(tipoTel);
		
		return dto;

	}
	

	public static TelefonoForm getForm(Telefono telefono) {
		TelefonoForm form=new TelefonoForm();
		
		form.setId(telefono.getId());
		form.setCodigoArea(String.valueOf(telefono.getCodigoArea()));
		form.setCodigoPais(String.valueOf(telefono.getCodigoPais()));
		form.setNumero(String.valueOf(telefono.getNumero()));
		form.setPersona(telefono.getPersona());
		form.setPrefijo(String.valueOf(telefono.getPrefijo()));
		form.setTipoTelefono(telefono.getTipoTelefono().getId());
		form.setTipoTelefonoNombre(telefono.getTipoTelefono().getNombre());
		
	
		return form;
	}

	public static List <Telefono> getTelefonos(String listaTelefonos) {

		   List <Telefono> telefonos = new ArrayList<Telefono>();
			
		   
			try {
				if (listaTelefonos != null){
					JSONArray json = (JSONArray)new JSONParser().parse(listaTelefonos);
					Iterator it = 	json.iterator();
				        while( it.hasNext() ){
				        	JSONObject nodo = (JSONObject)it.next();
				        	Telefono dto = new Telefono();
	
				    		dto.setId(((Long) nodo.get("idTel")).intValue());
				    		dto.setCodigoArea(((Long) nodo.get("State")).intValue());
				    		dto.setCodigoPais(((Long) nodo.get("Country")).intValue());
				    		dto.setNumero(((Long) nodo.get("Telefono")).intValue());
				    		dto.setPrefijo(((Long) nodo.get("Prefix")).intValue());
				    		TipoTelefono tipoTel = new TipoTelefono();
				    		tipoTel.setId(((Long) nodo.get("tipoTe")).intValue());
				    		dto.setTipoTelefono(tipoTel);
				    		telefonos.add(dto);
						         
				        }		
				}

			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return telefonos;

	}

	
}
