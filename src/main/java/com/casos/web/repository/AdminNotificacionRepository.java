package com.casos.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.Notificacion;

@Repository
public interface AdminNotificacionRepository extends JpaRepository<Notificacion, Long> {

	/**
	 * Logica de Notificacion
	 */
	Notificacion save(Notificacion notificacion);
	
}
