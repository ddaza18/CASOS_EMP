package com.casos.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles_casos")
public class RolUsersModel {

	@Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long id_rol;
	private String nombre_rol;

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public RolUsersModel(Long id_rol, String nombre_rol) {
		super();
		this.id_rol = id_rol;
		this.nombre_rol = nombre_rol;
	}

	public RolUsersModel() {
		super();
	}

	public RolUsersModel(String nombre_rol) {
		super();
		this.nombre_rol = nombre_rol;
	}

}
