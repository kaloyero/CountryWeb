package com.country.hibernate.model;

import java.io.Serializable;
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
@Table(name = "Vehiculos")
public class Vehiculo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdVehiculo", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "codigo")
	private  String codigo ;
	
	@Column(name = "descripcion")
	private  String descripcion ;

	@Column(name = "CIlindrada")
	private  String cilindrada;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnidad")		
	private  Unidad unidad;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdTipoVehiculo",updatable = true, insertable = true)	
	private TipoVehiculo tipoVehiculo;

    @OneToMany(fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdInfraccion",updatable = true, insertable = true , nullable = true)
	private List <Infraccion> infracciones;

	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


}
