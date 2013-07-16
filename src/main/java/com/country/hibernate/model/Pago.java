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
@Table(name = "Pagos")
public class Pago implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Pago() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdPago", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "fecha")
	private  Date fecha ;
	
	@Column(name = "referencia")
	private  String referencia ;
	
	@Column(name = "importe")
	private  double monto;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdTipoPago")		
	private  TipoPagos tipoPago;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnidad")		
	private  Unidad unidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public TipoPagos getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPagos tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

}
