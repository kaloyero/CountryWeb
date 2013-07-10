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
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "Provincias")
public class Provincia implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdProvincia", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Nombre")
	private String name;
	
	@Column(name = "CodigoISO")
	private String IsoCode;
	
    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdProvincia",updatable = true, insertable = true)
	private  List <Ciudad> cities ;

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

	public String getIsoCode() {
		return IsoCode;
	}

	public void setIsoCode(String isoCode) {
		IsoCode = isoCode;
	}

	public List<Ciudad> getCities() {
		return cities;
	}

	public void setCities(List<Ciudad> cities) {
		this.cities = cities;
	}
    
    


}
