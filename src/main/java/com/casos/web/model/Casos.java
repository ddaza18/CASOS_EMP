package com.casos.web.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "casos")
public class Casos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_caso;
	private String descripcion;
	private String Telefono;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date fecha_creacion;
	private String estado_caso;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	public Casos() {
		super();
	}


	public Long getId_caso() {
		return id_caso;
	}


	public void setId_caso(Long id_caso) {
		this.id_caso = id_caso;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}


	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public String getEstado_caso() {
		return estado_caso;
	}


	public void setEstado_caso(String estado_caso) {
		this.estado_caso = estado_caso;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	
}
