package com.country.mappers;


import com.country.form.VehiculoForm;
import com.country.hibernate.model.TipoVehiculo;
import com.country.hibernate.model.Unidad;
import com.country.hibernate.model.Vehiculo;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class VehiculoMapper {

	public static Vehiculo getvehiculo(VehiculoForm vehiculoForm)
			throws ParseException {
		
		Vehiculo vehiculo = new Vehiculo();
		Unidad unidad =new Unidad();
		unidad.setId(vehiculoForm.getUnidad());
		TipoVehiculo tipoVeh =new TipoVehiculo();
		tipoVeh.setId(vehiculoForm.getTipoVeh());

		vehiculo.setId(vehiculoForm.getId());
		vehiculo.setUnidad(unidad);
		vehiculo.setTipoVehiculo(tipoVeh);
		vehiculo.setCilindrada(vehiculoForm.getCilindrada());
		vehiculo.setCodigo(vehiculoForm.getCodigo());
		vehiculo.setDescripcion(vehiculoForm.getDescripcion());
		return vehiculo;
	
	}
	
	public static VehiculoForm getForm(Vehiculo vehiculo)
			throws ParseException {
		
		VehiculoForm vehiculoForm=new VehiculoForm();
		vehiculoForm.setId(vehiculo.getId());
		vehiculoForm.setCodigo(vehiculo.getCodigo());
		vehiculoForm.setCilindrada(vehiculo.getCilindrada());
		vehiculoForm.setDescripcion(vehiculo.getDescripcion());
		vehiculoForm.setTipoVeh(vehiculo.getTipoVehiculo().getId());
		vehiculoForm.setUnidad(vehiculo.getUnidad().getId());
		
		return vehiculoForm;
	
	}

}
