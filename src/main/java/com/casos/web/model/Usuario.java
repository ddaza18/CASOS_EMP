package com.casos.web.model;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios_casos", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	private String name_user;
	private String app_user;
	private String email;
	private String password_user;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_casos_roles", joinColumns = 
	//SE REFERENCIA A ESTA MISMA ENTIDAD Y CREA "USER_ID"
	@JoinColumn(name = "user_id", referencedColumnName = "id_user"), inverseJoinColumns =
	//SE REFERANCIA A LA OTRA ENTIDAD Y CREA "ROL_ID"
	@JoinColumn(name = "rol_id", referencedColumnName = "id_rol"))

	private Collection<RolUsersModel> roles_user;

	

	


	public Long getId_user() {
		return id_user;
	}






	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}






	public String getName_user() {
		return name_user;
	}






	public void setName_user(String name_user) {
		this.name_user = name_user;
	}






	public String getApp_user() {
		return app_user;
	}






	public void setApp_user(String app_user) {
		this.app_user = app_user;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getPassword_user() {
		return password_user;
	}






	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}






	public Collection<RolUsersModel> getRoles_user() {
		return roles_user;
	}






	public void setRoles_user(Collection<RolUsersModel> roles_user) {
		this.roles_user = roles_user;
	}






	public Usuario(Long id_user, String name_user, String app_user, String email, String password_user,
			Collection<RolUsersModel> roles_user) {
		super();
		this.id_user = id_user;
		this.name_user = name_user;
		this.app_user = app_user;
		this.email = email;
		this.password_user = password_user;
		this.roles_user = roles_user;
	}



	public Usuario(String name_user, String app_user, String email, String password_user,
			Collection<RolUsersModel> roles_user) {
		super();
		this.name_user = name_user;
		this.app_user = app_user;
		this.email = email;
		this.password_user = password_user;
		this.roles_user = roles_user;
	}



	public Usuario() {
		
	}

	
}
