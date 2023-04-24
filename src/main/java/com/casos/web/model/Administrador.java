package com.casos.web.model;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String admin;
	private String token;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_casos_roles", joinColumns = 
	@JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = 
	@JoinColumn(name = "rol_id", referencedColumnName = "id_rol"))
	
	private Collection<RolUsersModel> rol_admin;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
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
