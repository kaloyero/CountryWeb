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
@Table(name = "Infracciones")
public class Infraccion implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdInfraccion", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "fecha")
	private  Date fecha;

	@Column(name = "numero")
	private  String numero ;

	@Column(name = "motivo")
	private  String motivo ;

	@Column(name = "importe")
	private  double monto ;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnidad")		
	private  Unidad unidad;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdTipoInfraccion")		
	private  TipoInfraccion tipoInfraccion;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdVehiculo")		
	private  Vehiculo vehiculo;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="IdMascota")		
//	private  Mascota mascota;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public TipoInfraccion getTipoInfraccion() {
		return tipoInfraccion;
	}

	public void setTipoInfraccion(TipoInfraccion tipoInfraccion) {
		this.tipoInfraccion = tipoInfraccion;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
