package com.casos.web.dto;

public class UsersRegisterDTO {

	private Long id_user;
	private String password_user;
	private String name_user;
	private String app_user;
	private String email;
	
	
	
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getPassword_user() {
		return password_user;
	}
	public void setPassword_user(String password_user) {
		this.password_user = password_user;
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
	
	
	public UsersRegisterDTO(Long id_user, String password_user, String name_user, String app_user, String email) {
		super();
		this.id_user = id_user;
		this.password_user = password_user;
		this.name_user = name_user;
		this.app_user = app_user;
		this.email = email;
	}
	public UsersRegisterDTO(String password_user, String name_user, String app_user, String email) {
		super();
		this.password_user = password_user;
		this.name_user = name_user;
		this.app_user = app_user;
		this.email = email;
	}
	public UsersRegisterDTO() {
		super();
	}

		
}
