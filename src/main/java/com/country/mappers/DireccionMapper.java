package com.country.mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.country.form.DireccionForm;
import com.country.form.Form;
import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Localidad;

public class DireccionMapper {

	public static Direccion getDireccion(Form form) {
		
		Direccion dto = new Direccion();

		dto.setId(((DireccionForm) form).getId());
		dto.setBlock(((DireccionForm) form).getBlock());
		dto.setFlat(((DireccionForm) form).getFlat());
		dto.setFloor(((DireccionForm) form).getFloor());
		dto.setPerson(((DireccionForm) form).getPerson());
		dto.setStreetName(((DireccionForm) form).getStreetName());
		dto.setStreetNumber(((DireccionForm) form).getStreetNumber());
		dto.setTower(((DireccionForm) form).getTower());
		Localidad town = new Localidad();
		town.setId(((DireccionForm) form).getTown());
		dto.setTown(town);
		
		return dto;

	}
	

	public static DireccionForm getForm(Direccion direccion) {
		DireccionForm form=new DireccionForm();
		form.setBlock(direccion.getBlock());
		form.setFlat(direccion.getFlat());
		form.setFloor(direccion.getFloor());
		form.setId(direccion.getId());
		form.setPerson(direccion.getPerson());
		form.setStreetName(direccion.getStreetName());
		form.setStreetNumber(direccion.getStreetNumber());
		form.setTower(direccion.getTower());
		form.setTown(direccion.getTown().getId());

		return form;
	}
	
	public static List <Direccion> getDirecciones(String listaDirecciones) {

		   List <Direccion> direcciones = new ArrayList<Direccion>();
			
		   
			try {
				if (listaDirecciones != null){
					JSONArray json = (JSONArray)new JSONParser().parse(listaDirecciones);
					Iterator it = 	json.iterator();
				        while( it.hasNext() ){
				        	JSONObject nodo = (JSONObject)it.next();
				        	Direccion dto = new Direccion();
	
				    		dto.setId(((Long) nodo.get("IdDir")).intValue());
				    		dto.setStreetName(((String) nodo.get("StreetName")).toString());
				    		dto.setStreetNumber(((String) nodo.get("StreetNum")).toString());
				    		dto.setFloor(((String) nodo.get("Floor")).toString());
				    		dto.setFlat(((String) nodo.get("Flat")).toString());
				    		dto.setTower(((String) nodo.get("Tower")).toString());
				    		dto.setBlock(((String) nodo.get("Block")).toString());
				    		Localidad town = new Localidad();
				    		town.setId(((Long) nodo.get("IdTownDir")).intValue());
				    		dto.setTown(town);
				    		direcciones.add(dto);
						         
				        }		
				}

			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return direcciones;

	}
	
	
}
