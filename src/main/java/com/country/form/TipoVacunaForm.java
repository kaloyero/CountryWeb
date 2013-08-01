package com.country.form;


public class TipoVacunaForm extends TipoForm  {

	private int especie;
	
	private int vigencia;

	private boolean obligatoria;
	
	public int getEspecie() {
		return especie;
	}

	public void setEspecie(int especie) {
		this.especie = especie;
	}

	public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public boolean isObligatoria() {
		return obligatoria;
	}

	public void setObligatoria(boolean obligatoria) {
		this.obligatoria = obligatoria;
	}

	
	

}
