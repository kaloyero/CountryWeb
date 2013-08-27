package com.country.form;



public class AvisoForm extends Form  {

	private Integer id =0;
	private String fecha;
	private String titulo;
	private String encabezado;
	private String cuerpo;
	private String cierre;
	private String fechaCierre;
	private  int categoria;
	private  String categoriaDescription;

	private  String unidad;
	private  Double importe;

	private  int persona;
	private  String personaNombre;

	private boolean envioAdm=false;

	public boolean isEnvioAdm() {
		return envioAdm;
	}
	public void setEnvioAdm(boolean envioAdm) {
		this.envioAdm = envioAdm;
	}
	public String getCategoriaDescription() {
		return categoriaDescription;
	}
	public void setCategoriaDescription(String categoriaDescription) {
		this.categoriaDescription = categoriaDescription;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEncabezado() {
		return encabezado;
	}
	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public String getCierre() {
		return cierre;
	}
	public void setCierre(String cierre) {
		this.cierre = cierre;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getPersona() {
		return persona;
	}
	public void setPersona(int persona) {
		this.persona = persona;
	}
	public String getPersonaNombre() {
		return personaNombre;
	}
	public void setPersonaNombre(String personaNombre) {
		this.personaNombre = personaNombre;
	}

	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}


	
	
}
