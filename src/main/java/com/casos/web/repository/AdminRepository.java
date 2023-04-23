package com.casos.web.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.Administrador;

@Repository
public interface AdminRepository extends JpaRepository<Administrador, Long>  {

	public Administrador findByAdminUsAndToken(String adminUs, String token);
	
}
