package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Personas")
public class Persona implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdPersona", unique = true, nullable = false)	
	private int id;
	
	@Column(name = "Nombre", nullable = false)
	private String nombre;
	
	@Column(name = "Apellido", nullable = false)
	private String apellido;
	
	@Column(name = "FechaNacimiento", nullable = false)
	private Date dtNacimiento;

	@Column(name = "Sexo", nullable = false)
	private String sexo;
	
	@Column(name = "Tipo", updatable = false)
	private String tipo;

	@Column(name = "NroDocumento")
	private String nroDoc;
	
	@Column(name = "DireccionEmail")
	private String email;
	
	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="IdTipoDocumento",updatable = true, insertable = true)	
	private TipoDocumento tipoDoc;
	
	public Date getDtNacimiento() {
		return dtNacimiento;
	}

	public void setDtNacimiento(Date dtNacimiento) {
		this.dtNacimiento = dtNacimiento;
	}
	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
