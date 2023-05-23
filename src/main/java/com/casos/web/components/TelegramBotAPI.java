package com.casos.web.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBotAPI extends TelegramLongPollingBot{
public static final Logger LOG = LoggerFactory.getLogger(TelegramBotAPI.class);
	
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
			/*if(adminTelegramRepository != null) {
				
			mensajesTelegram.setFechaenvio(new Date());
			mensajesTelegram.setMensaje(mensaje);
			LOG.info("Guardando Mensaje recibido a BD");
			adminTelegramRepository.save(mensajesTelegram);
			}
			else {
				LOG.error("Error al guardar el mensaje de Telegram.");
			}*/
		}catch(TelegramApiException e){
			LOG.error("Ocurrio un error en el envio de la respuesta al BOT de telegram", e.getMessage());
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
