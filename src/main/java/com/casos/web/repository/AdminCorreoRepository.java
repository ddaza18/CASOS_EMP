package com.casos.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.Correo;

@Repository
public interface AdminCorreoRepository extends JpaRepository<Correo, Long>{

  Correo save(Correo correo);
}
