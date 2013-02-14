package com.country.hibernate.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "Unidades", catalog = "country")
public class Unidad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdUnidad", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Codigo")
	private String code;
	
	@Column(name = "Descripcion")
	private String description;
	
	@OneToOne(fetch=FetchType.EAGER )

    @JoinColumn(name="IdEmprendimiento",updatable = true, insertable = true)	
	private Emprendimiento business;


    @OneToMany(fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdUnidad",updatable = true, insertable = true , nullable = true)
	private List <Integrante> integrantes;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdVehiculo",updatable = true, insertable = true , nullable = true)
	private List <Vehiculo> vehiculos;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdPago",updatable = true, insertable = true , nullable = true)
	private List <Pago> pagos;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdCargo",updatable = true, insertable = true , nullable = true)
	private List <LiquidacionCargo> cargos;
    
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdReserva",updatable = true, insertable = true , nullable = true)
	private List <Reserva> reservas;
    
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdInfraccion",updatable = true, insertable = true , nullable = true)
	private List <Infraccion> infracciones;
    
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdMascota",updatable = true, insertable = true , nullable = true)
	private List <Mascota> mascotas;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdAutorizado",updatable = true, insertable = true , nullable = true)
	private List <Autorizado> autorizados;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Emprendimiento getBusiness() {
		return business;
	}

	public void setBusiness(Emprendimiento business) {
		this.business = business;
	}

	public List<Integrante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<LiquidacionCargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<LiquidacionCargo> cargos) {
		this.cargos = cargos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Infraccion> getInfracciones() {
		return infracciones;
	}

	public void setInfracciones(List<Infraccion> infracciones) {
		this.infracciones = infracciones;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public List<Autorizado> getAutorizados() {
		return autorizados;
	}

	public void setAutorizados(List<Autorizado> autorizados) {
		this.autorizados = autorizados;
	}

	
}
