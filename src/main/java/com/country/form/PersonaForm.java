package com.country.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PersonaForm extends Form  {

	private Integer id=0;
	private String nombre;
	private String apellido;
	private String nacimiento;
	private String sexo;
	private String nroDoc;
	private String email;
	private int tipoDocumento;
	
	private Map<Integer, String> direcciones = new HashMap<Integer, String>();
	private Map<Integer, String> telefonos = new HashMap<Integer, String>();

	private List<DireccionForm> listaDirecciones = new ArrayList<DireccionForm>();
	private List<TelefonoForm> listaTelefonos = new ArrayList<TelefonoForm>();


	public Map<Integer, String> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(Map<Integer, String> direcciones) {
		this.direcciones = direcciones;
	}

	public Map<Integer, String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Map<Integer, String> telefonos) {
		this.telefonos = telefonos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<DireccionForm> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<DireccionForm> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	public List<TelefonoForm> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(List<TelefonoForm> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

}
