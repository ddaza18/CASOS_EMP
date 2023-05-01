package com.casos.web.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "correo")
public class Correo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_correo;
	
	private String para;
	
	private String subject;
	
	private String cont;
	
	private Date fechaDeEnvio;
	
	
	public Long getId_correo() {
		return id_correo;
	}
	public void setId_correo(Long id_correo) {
		this.id_correo = id_correo;
	}
	
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getFechaDeEnvio() {
		return fechaDeEnvio;
	}
	public void setFechaDeEnvio(Date fechaDeEnvio) {
		this.fechaDeEnvio = fechaDeEnvio;
	}
	

}
