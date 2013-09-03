package com.country.mappers;

import com.country.common.DateUtil;
import com.country.form.Form;
import com.country.form.InfraccionForm;
import com.country.hibernate.model.Infraccion;
import com.country.hibernate.model.Mascota;
import com.country.hibernate.model.Tarifa;
import com.country.hibernate.model.TipoInfraccion;
import com.country.hibernate.model.Unidad;
import com.country.hibernate.model.Vehiculo;

public class InfraccionMapper {

	public static Infraccion getInfraccion(InfraccionForm form) {
		
		Infraccion infraccion = new Infraccion();
		
		infraccion.setId(form.getId());
		infraccion.setFecha(DateUtil.convertStringToDate(form.getFecha()));
		infraccion.setMonto(Double.parseDouble(form.getImporte()));
		infraccion.setMotivo(form.getMotivo());
		infraccion.setNumero(form.getNumero());
		
		TipoInfraccion tipo = new TipoInfraccion();
		tipo.setId(form.getTipoInfraccion().getId());
		infraccion.setTipoInfraccion(tipo);

		Unidad unidad = new Unidad();
		unidad.setId(form.getUnidadId());
		infraccion.setUnidad(unidad);
		
		if (form.getVehiculoId() != null){
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setId(form.getVehiculoId());
			infraccion.setVehiculo(vehiculo);
		}
		
		if (form.getMascotaId() != null){
			Mascota mascota = new Mascota();
			mascota.setId(form.getMascotaId());
			infraccion.setMascota(mascota);
		}

		return infraccion;

	}
	

	public static Form getForm(Infraccion infraccion,Tarifa tarifa) {
		InfraccionForm form=new InfraccionForm();

		form.setId(infraccion.getId());
		form.setFecha(DateUtil.convertDateToString(infraccion.getFecha()));
		form.setImporte(String.valueOf(infraccion.getMonto()));
		form.setMotivo(infraccion.getMotivo());
		form.setNumero(infraccion.getNumero());
		form.setTipoInfraccion(TipoMapper.getForm(infraccion.getTipoInfraccion(),tarifa));
		form.setUnidadId(infraccion.getUnidad().getId());
		form.setUnidadDesc(infraccion.getUnidad().getCode());
		if (infraccion.getVehiculo() != null){
			form.setVehiculoId(infraccion.getVehiculo().getId());
			form.setVehiculoDesc(infraccion.getVehiculo().getTipoVehiculo().getNombre() + " " + infraccion.getVehiculo().getCodigo());
		}
		if (infraccion.getMascota() != null){
			form.setMascotaId(infraccion.getMascota().getId());
			form.setMascotaDesc(infraccion.getMascota().getRaza().getEspecie().getNombre() + " " + infraccion.getMascota().getRaza().getNombre() + " (" + infraccion.getMascota().getCodigo() + ")");
		}
		
		return form;
	}
	
}
