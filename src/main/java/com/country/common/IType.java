package com.country.common;

import java.io.Serializable;

public interface IType extends Serializable{

	public int getId();
	public void setId(int id);
	public String getNombre();
	public void setNombre(String nombre);
	
}
