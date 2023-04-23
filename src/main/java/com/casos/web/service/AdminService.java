package com.casos.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casos.web.model.Administrador;
import com.casos.web.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public boolean validateTokenAndUserAdmin(String userAdmin, String token) {
		Administrador administrador = adminRepository.findByAdminUsAndToken(userAdmin, token);
		return administrador != null;
	}
}
