package com.davidson.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.davidson.cursomc.services.DBService;
import com.davidson.cursomc.services.EmailService;
import com.davidson.cursomc.services.MockEmailService;

@Configuration
@Profile("test")//Beans de config daqui só serão ativos quando o properties ativado for o application-test
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailservice() {
		return new MockEmailService();
	}

}
