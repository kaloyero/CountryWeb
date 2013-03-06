package com.country.mappers;


import java.util.Date;

import com.country.form.MascotaForm;
import com.country.hibernate.model.Mascota;
import com.country.hibernate.model.Raza;
import com.country.hibernate.model.Unidad;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class MascotaMapper {

	public static Mascota getMascota(MascotaForm mascotaForm)
			throws ParseException {
		
		Mascota	mascota = new Mascota();
		
		Unidad unidad =new Unidad();
		unidad.setId(mascotaForm.getUnidad());
		Raza raza = new Raza();
		raza.setId(mascotaForm.getUnidad());
		
		mascota.setId(mascotaForm.getId());
		mascota.setUnidad(unidad);
		mascota.setCodigo(mascotaForm.getCodigo());
		mascota.setNombre(mascotaForm.getNombre());
		mascota.setSexo(mascotaForm.getSexo());
		mascota.setFechaNac(new Date(2012, 12, 12));
		mascota.setTamano(mascotaForm.getTamanio());
		mascota.setColor(mascotaForm.getColor());
		mascota.setDistincion(mascotaForm.getMarcasDist());
		mascota.setRaza(raza);
		
		return mascota;
	
	}
	
	public static MascotaForm getForm(Mascota mascota)
			throws ParseException {
		
		MascotaForm mascotaForm=new MascotaForm();
		mascotaForm.setId(mascota.getId());
		mascotaForm.setCodigo(mascota.getCodigo());
		mascotaForm.setUnidad(mascota.getUnidad().getId());
		mascotaForm.setNombre(mascota.getNombre());
		mascotaForm.setSexo(mascota.getSexo());
		mascotaForm.setfNac(String.valueOf(mascota.getFechaNac()));
		mascotaForm.setTamanio(mascota.getTamano());
		mascotaForm.setColor(mascota.getColor());
		mascotaForm.setMarcasDist(mascota.getDistincion());
		mascotaForm.setRaza(mascota.getRaza().getId());
		
		return mascotaForm;
	
	}

}
