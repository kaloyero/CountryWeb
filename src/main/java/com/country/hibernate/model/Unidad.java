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
    @JoinColumn(name="IdEmprendimiento")	
	private Emprendimiento business;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@BatchSize(size = 10)
    @JoinColumn(name="IdUnidad",updatable = true, insertable = true , nullable = true)
	private List <Integrante> integrantes;

	
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
	
	
}
