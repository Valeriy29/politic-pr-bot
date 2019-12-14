package com.example;

import com.example.controller.BotController;
import com.example.migration.DocumentsLoad;
import com.example.migration.ElectionsMigration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


@SpringBootApplication
public class PoliticPrBotApplication implements CommandLineRunner {

	static {
		ApiContextInitializer.init();
	}

	@Autowired
	private BotController botController;

	@Autowired
    private ElectionsMigration electionsMigration;

	@Autowired
	private DocumentsLoad documentsLoad;

	@Bean
	TelegramBotsApi getTelegramBotsApi() {
		return new TelegramBotsApi();
	}

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(PoliticPrBotApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			getTelegramBotsApi().registerBot(botController);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
		//electionsMigration.saveAll()
		documentsLoad.saveAllDocuments();
	}

}
