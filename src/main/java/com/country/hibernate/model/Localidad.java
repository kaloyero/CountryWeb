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

@Entity
@Table(name = "Localidades", catalog = "country")
public class Localidad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdLocalidad", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Nombre")
	private String name;
	
	@Column(name = "CodigoPostal")
	private String postalCode;
	
	@OneToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="IdCiudad")	
	private Ciudad city;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Ciudad getCity() {
		return city;
	}

	public void setCity(Ciudad city) {
		this.city = city;
	}
	
	
}
