package com.example;

import com.example.controller.BotController;
import com.example.repository.ElectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PoliticPrBotApplication implements CommandLineRunner {

	static {
		ApiContextInitializer.init();
	}

	@Autowired
	private BotController botController;

	@Autowired
    private SaveServiceTest saveServiceTest;

	@Autowired
	ElectionsRepository electionsRepository;

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
	public void run(String... args) throws Exception {
		try {
			getTelegramBotsApi().registerBot(botController);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
		System.out.println(electionsRepository.findElectionsEntityByKeyword("ШИЯ", "2020"));
	}

	@PostConstruct
    public void test() {

    }
}
