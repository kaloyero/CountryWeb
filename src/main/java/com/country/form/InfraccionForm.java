package com.country.form;


public class InfraccionForm extends Form  {
	
	private Integer id =0;
	private String fecha ;
	private String motivo;
	private String importe;
	private String numero;
	private int unidadId;
	private String unidadDesc;
	private TipoInfraccionForm tipoInfraccion;
	private Integer vehiculoId;
	private String vehiculoDesc;
	private Integer mascotaId;
	private String mascotaDesc;

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
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getUnidadId() {
		return unidadId;
	}
	public void setUnidadId(int unidadId) {
		this.unidadId = unidadId;
	}
	public String getUnidadDesc() {
		return unidadDesc;
	}
	public void setUnidadDesc(String unidadDesc) {
		this.unidadDesc = unidadDesc;
	}
	public TipoInfraccionForm getTipoInfraccion() {
		return tipoInfraccion;
	}
	public void setTipoInfraccion(TipoInfraccionForm tipoInfraccion) {
		this.tipoInfraccion = tipoInfraccion;
	}
	public String getVehiculoDesc() {
		return vehiculoDesc;
	}
	public void setVehiculoDesc(String vehiculoDesc) {
		this.vehiculoDesc = vehiculoDesc;
	}
	public String getMascotaDesc() {
		return mascotaDesc;
	}
	public void setMascotaDesc(String mascotaDesc) {
		this.mascotaDesc = mascotaDesc;
	}
	public Integer getVehiculoId() {
		return vehiculoId;
	}
	public void setVehiculoId(Integer vehiculoId) {
		this.vehiculoId = vehiculoId;
	}
	public Integer getMascotaId() {
		return mascotaId;
	}
	public void setMascotaId(Integer mascotaId) {
		this.mascotaId = mascotaId;
	}
	
}
