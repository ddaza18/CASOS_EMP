package com.casos.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enviossms")
public class Sms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sms;
	
	private String desde;
	
	private String para;
	
	private Date fechaenvio;
	
	private String contenido;
	

	public Long getId_sms() {
		return id_sms;
	}

	public void setId_sms(Long id_sms) {
		this.id_sms = id_sms;
	}

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public Date getFechaenvio() {
		return fechaenvio;
	}

	public void setFechaenvio(Date fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
}
