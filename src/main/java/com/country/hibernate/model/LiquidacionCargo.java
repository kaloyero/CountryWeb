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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "liquidacionCargos", catalog = "country")
public class LiquidacionCargo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdCargo", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "Fecha")
	private  Date fecha ;
	
	@Column(name = "Importe")
	private  double monto ;

	@Column(name = "modo")
	private  String modo;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdLiquidacion")		
	private  Liquidacion liquidacion;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnidad")		
	private  Unidad unidad;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdConcepto")		
	private  Concepto concepto;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdInfraccion")		
	private  Infraccion infraccion;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdUnidadConcepto")		
	private  UnidadConcepto unidadconcepto;
	
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "IntegranteActividades", catalog = "country", joinColumns = {@JoinColumn(name = "IdActividad", nullable = false, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "IdIntegrante", nullable = false, updatable = true) })
	private  List <Integrante> integrantes ;
	
    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdReserva")		
	private  Reserva reserva;

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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getModo() {
		return modo;
	}

	public void setModo(String modo) {
		this.modo = modo;
	}

	public Liquidacion getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(Liquidacion liquidacion) {
		this.liquidacion = liquidacion;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public Infraccion getInfraccion() {
		return infraccion;
	}

	public void setInfraccion(Infraccion infraccion) {
		this.infraccion = infraccion;
	}

	public UnidadConcepto getUnidadconcepto() {
		return unidadconcepto;
	}

	public void setUnidadconcepto(UnidadConcepto unidadconcepto) {
		this.unidadconcepto = unidadconcepto;
	}

	public List<Integrante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
}
