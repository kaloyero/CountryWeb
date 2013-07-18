package com.country.mappers;

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
	
}
