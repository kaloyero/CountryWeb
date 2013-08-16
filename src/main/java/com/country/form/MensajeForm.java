	package com.country.form;

import java.util.HashMap;
import java.util.Map;

public class MensajeForm extends Form  {

	private int id =0;
	private String fecha;
	private String tipo;
	private String asunto;
	private String estado;
	private String fechaCierre;
	private String resolucion;
	private int categoria;
	private String categoriaDescripcion;
	private String respuesta;
	private String accion;
	private int cantidadDestalles;
	private int idIntegrante;
	private String integranteNombre;
	private int idEmpleado;
	private boolean envio; //este campo hace referencia a quien creo el mensaje (ADM o integrante)
	private Map<Integer, String> detalles = new HashMap<Integer, String>();
	
	
	public boolean isEnvio() {
		return envio;
	}
	public void setEnvio(boolean envio) {
		this.envio = envio;
	}
	public String getIntegranteNombre() {
		return integranteNombre;
	}
	public void setIntegranteNombre(String integranteNombre) {
		this.integranteNombre = integranteNombre;
	}
	public int getIdIntegrante() {
		return idIntegrante;
	}
	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getCantidadDestalles() {
		return cantidadDestalles;
	}
	public void setCantidadDestalles(int cantidadDestalles) {
		this.cantidadDestalles = cantidadDestalles;
	}
	public String getCategoriaDescripcion() {
		return categoriaDescripcion;
	}
	public void setCategoriaDescripcion(String categoriaDescripcion) {
		this.categoriaDescripcion = categoriaDescripcion;
	}
	public Map<Integer, String> getDetalles() {
		return detalles;
	}
	public void setDetalles(Map<Integer, String> detalles) {
		this.detalles = detalles;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}

	
}
