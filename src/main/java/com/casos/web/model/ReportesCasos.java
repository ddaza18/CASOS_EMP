package com.casos.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reportes")
public class ReportesCasos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fechaCreacion;
	private String descripcion;
	private String telefonoCaso;
	private String usuarioCrea;
	private String correoUsuarioCrea;
	private String estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTelefonoCaso() {
		return telefonoCaso;
	}
	public void setTelefonoCaso(String telefonoCaso) {
		this.telefonoCaso = telefonoCaso;
	}
	public String getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(String usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public String getCorreoUsuarioCrea() {
		return correoUsuarioCrea;
	}
	public void setCorreoUsuarioCrea(String correoUsuarioCrea) {
		this.correoUsuarioCrea = correoUsuarioCrea;
	}
	
	
}
