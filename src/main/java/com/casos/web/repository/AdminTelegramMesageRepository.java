package com.casos.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casos.web.model.MensajesTelegram;

@Repository
public interface AdminTelegramMesageRepository extends JpaRepository<MensajesTelegram, Long>{
	
	/**
	 * Logica de la interfaz "Envio de SMS con Telegram"
	 */
	
	MensajesTelegram save(MensajesTelegram save);
	
	List<MensajesTelegram> findAll();

}
