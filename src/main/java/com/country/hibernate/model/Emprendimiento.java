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
@Table(name = "Emprendimientos")
public class Emprendimiento implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdEmprendimiento", unique = true, nullable = false)	
	private Integer id;
	
	@Column(name = "Nombre")
	private String name;
	
	@Column(name = "Descripcion")
	private String description;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdLocalidad",updatable = true, insertable = true)	
	private Localidad town;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdEmprendimiento",updatable = true, insertable = true)
	private  List <Unidad> units ;
	
	public List<Unidad> getUnits() {
		return units;
	}

	public void setUnits(List<Unidad> units) {
		this.units = units;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Localidad getTown() {
		return town;
	}

	public void setTown(Localidad town) {
		this.town = town;
	}

	
	
}
