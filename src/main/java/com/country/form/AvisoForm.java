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
	private  int integrante;
	private  String integranteNombre;
	private  String integranteApellido;
	private  String unidad;
	private  Double importe;


	
	
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
	public int getIntegrante() {
		return integrante;
	}
	public void setIntegrante(int integrante) {
		this.integrante = integrante;
	}
	public String getIntegranteNombre() {
		return integranteNombre;
	}
	public void setIntegranteNombre(String integranteNombre) {
		this.integranteNombre = integranteNombre;
	}
	public String getIntegranteApellido() {
		return integranteApellido;
	}
	public void setIntegranteApellido(String integranteApellido) {
		this.integranteApellido = integranteApellido;
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
