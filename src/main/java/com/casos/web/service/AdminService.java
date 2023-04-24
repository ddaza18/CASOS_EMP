package com.casos.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casos.web.model.Administrador;
import com.casos.web.repository.AdminRepository;

@Service
public class AdminService {
	public static final Logger LOG = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminRepository adminRepository;
	
	public boolean validateTokenAndUserAdmin(String admin, String token) {
		Administrador administrador = adminRepository.findByAdminUsAndToken(admin, token);
		LOG.info("Validando datos ingresados en el form de Administrador validateTokenAndUserAdmin...");
		return administrador != null;
	}
}
