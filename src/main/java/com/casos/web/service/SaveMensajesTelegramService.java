package com.casos.web.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.casos.web.model.MensajesTelegram;
import com.casos.web.repository.AdminTelegramRepository;

public class SaveMensajesTelegramService {
public static final Logger LOG = LoggerFactory.getLogger(SaveMensajesTelegramService.class);


	private AdminTelegramRepository adminTelegramRepository;

	@Autowired
	public SaveMensajesTelegramService(AdminTelegramRepository adminTelegramRepository) {
		this.adminTelegramRepository = adminTelegramRepository;
	}
	
	public void guardarMensajeRecibidoTelegram(String msj) {
		MensajesTelegram mensajesTelegram = new MensajesTelegram();
		mensajesTelegram.setMensaje(msj);
		mensajesTelegram.setFechaenvio(new Date());
		adminTelegramRepository.save(mensajesTelegram);	
	}

}
