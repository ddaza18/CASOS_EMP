package com.casos.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotAPIService extends TelegramLongPollingBot{
public static final Logger LOG = LoggerFactory.getLogger(TelegramBotAPIService.class);
	
private SaveMensajesTelegramService saveMensajesTelegramService;

	@Override
	public void onUpdateReceived(Update update) {
		
		String mensaje = update.getMessage().getText();
		LOG.info("Escribieron en el BOT: " + mensaje);
		
		//Obtiene el id del usuario y lo parsea
		final String chatId = update.getMessage().getChatId().toString();
		
		//Crea un objeto del mensaje
		SendMessage message = new SendMessage();
		message.setChatId(chatId);
		message.setText("Gracias por escribirnos por el chat de CASOS EMP");
		try {
			//Envia el mensaje al chat Telegram
			execute(message);
			LOG.info("Respuesta enviada al BOT de telegram.");
		}catch(TelegramApiException e){
			LOG.error("Ocurrio un error en el envio de la respuesta al BOT de telegram", e.getMessage());
		}
		
		/*
		 * Guardado de mensaje recibido por el BOT de telegram
		 */
		if(saveMensajesTelegramService != null) {
		saveMensajesTelegramService.guardarMensajeRecibidoTelegram(mensaje);
		LOG.info("Guardando el mensaje recibido por el BOT en BD...");
		}else {
			LOG.error("Ocurrio un error al gudardar el mensaje (NullPointer)....");
		}
		
	}
	
	/**
	 * Token de acceso para el BOT y nombre
	 */
	@Override
	public String getBotUsername() {
		String nameBot = "pruebasemp_bot";
		return nameBot;
	}

	@Override
	public String getBotToken() {
		String tokenAcceso = "6270890199:AAESq1AUIjcFdNmakSksch0BYPKlN1sd_3k";
		return tokenAcceso;
	}
}
