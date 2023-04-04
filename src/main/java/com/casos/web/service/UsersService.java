package com.casos.web.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.casos.web.dto.UsersRegisterDTO;
import com.casos.web.model.Usuario;

public interface UsersService extends UserDetailsService{
	
	public Usuario save(UsersRegisterDTO registerDto);
	
}
