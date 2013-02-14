package com.country.hibernate.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "mascotas", catalog = "country")
public class Mascota implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdMascota", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "codigo")
	private  String codigo ;

	@Column(name = "color")
	private  String color;
	
	@Column(name = "nombre")
	private  String nombre ;

	@Column(name = "sexo")
	private  String sexo;

	@Column(name = "fechaNacimiento")
	private  Date fechaNac;
	
	@Column(name = "tamanio")
	private  String tamano ;

	@Column(name = "marcasdistintivas")
	private  String distincion ;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnidad")		
	private  Unidad unidad;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdRaza")		
	private  Raza raza;

	@OneToMany(fetch=FetchType.EAGER)
	@BatchSize(size = 10)
    @JoinColumn(name="IdVacuna",updatable = true, insertable = true , nullable = true)
	private List <Vacuna> vacunas;

    @OneToMany(fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdInfraccion",updatable = true, insertable = true , nullable = true)
	private List <Infraccion> infracciones;

	public List<Vacuna> getVacunas() {
		return vacunas;
	}

	public void setVacunas(List<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public void setInfracciones(List<Infraccion> infracciones) {
		this.infracciones = infracciones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getDistincion() {
		return distincion;
	}

	public void setDistincion(String distincion) {
		this.distincion = distincion;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}	

}
