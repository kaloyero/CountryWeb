package com.country.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Direcciones")
public class Direccion implements Serializable {
	
	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdDireccion", unique = true, nullable = false)	
	private int id;
	
	@Column(name = "CalleNombre", nullable = false)
	private String streetName;
	
	@Column(name = "CalleNumero", nullable = false)
	private String streetNumber;

	@Column(name = "Torre")
	private String tower;

	@Column(name = "Bloque")
	private String block;

	@Column(name = "Piso")
	private String floor;

	@Column(name = "Departamento")
	private String flat;
	
	@OneToOne(fetch= FetchType.EAGER)
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name="IdLocalidad",updatable = true, insertable = true)	
	private Localidad town;

	@Column(name = "IdPersona")
	private int person;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getTower() {
		return tower;
	}

	public void setTower(String tower) {
		this.tower = tower;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public Localidad getTown() {
		return town;
	}

	public void setTown(Localidad town) {
		this.town = town;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

}
