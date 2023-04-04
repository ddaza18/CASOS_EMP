package com.casos.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	public Usuario findByEmail(String email);
	
	List<Usuario> findAll();
	
	}


