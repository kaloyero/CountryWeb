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
@Table(name = "Ciudades", catalog = "country")
public class Ciudad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdCiudad", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Nombre")
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdProvincia")	
	private Provincia state;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdCiudad",updatable = true, insertable = true)
	private  List <Localidad> towns ;
	
    
	public List<Localidad> getTowns() {
		return towns;
	}

	public void setTowns(List<Localidad> towns) {
		this.towns = towns;
	}

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

	public Provincia getState() {
		return state;
	}

	public void setState(Provincia state) {
		this.state = state;
	}

	
}
