package com.country.common;

import org.apache.commons.lang.StringUtils;

import com.country.hibernate.model.Direccion;
import com.country.hibernate.model.Telefono;

public class FormaterObject {

	public static String getFormatPhone (Telefono tel){
		
		StringBuffer telefono = new StringBuffer(); 
		telefono .append(tel.getTipoTelefono().getNombre() + ": ") ;
		
		if (tel.getCodigoPais() != 0){
			telefono.append("("+String.valueOf(tel.getCodigoPais()));
			if (tel.getCodigoArea() !=0){
				telefono.append(String.valueOf(tel.getCodigoArea())) ;
			}
			telefono.append(") ");
		} else if (tel.getCodigoArea() !=0){
			telefono.append("("+String.valueOf(tel.getCodigoArea())+") ") ;
		}
		telefono.append(String.valueOf(tel.getNumero()));
		
		return telefono.toString();
	}
	
	public static String getFormatDirection (Direccion dir){
		
		StringBuffer direccion = new StringBuffer(); 
		direccion.append(dir.getStreetName() + " " + dir.getStreetNumber()); 
		if (StringUtils.isNotBlank(dir.getFlat())) {
			direccion.append(" " + dir.getFloor());
		}
		
		return direccion.toString();
	}

}
