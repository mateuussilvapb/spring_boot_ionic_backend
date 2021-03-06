package com.mateuussilvapb.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mateuussilvapb.services.DBService;
import com.mateuussilvapb.services.EmailService;
import com.mateuussilvapb.services.MockEmailService;

//=============================================================//
@Configuration
@Profile("test")
public class TestConfig {

	// =============================================================//
	@Autowired
	private DBService dbService;

	// =============================================================//
	@Bean
	public boolean instatntiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	// =============================================================//
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
