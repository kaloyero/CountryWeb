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
@Table(name = "NoticiaSuscripciones")
public class NoticiaSuscripciones implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdNoticiaSuscripcion", unique = true, nullable = false)
	private int id;
	
	@Column(name = "IdIntegrante")
	private int integrante;
	
    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IdCategoria")	
	private NoticiaCategorias categoria;

}
