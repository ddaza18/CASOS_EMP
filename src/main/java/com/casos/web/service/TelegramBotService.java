package com.casos.web.service;

import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramBotService extends TelegramLongPollingBot{
	

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		
	}
}
