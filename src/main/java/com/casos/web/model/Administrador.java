package com.casos.web.model;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_admin;
	private String admin_us;
	private String token;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_casos_roles", joinColumns = 
	@JoinColumn(name = "user_id", referencedColumnName = "id_admin"), inverseJoinColumns = 
	@JoinColumn(name = "rol_id", referencedColumnName = "id_rol"))
	
	private Collection<RolUsersModel> rol_admin;

	public Long getId() {
		return id_admin;
	}

	public void setId(Long id_admin) {
		this.id_admin = id_admin;
	}

	public String getUser() {
		return admin_us;
	}

	public void setUser(String admin_us) {
		this.admin_us = admin_us;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Collection<RolUsersModel> getRol_admin() {
		return rol_admin;
	}

	public void setRol_admin(Collection<RolUsersModel> rol_admin) {
		this.rol_admin = rol_admin;
	}
	
}
