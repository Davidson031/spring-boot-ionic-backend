package com.davidson.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.davidson.cursomc.services.DBService;
import com.davidson.cursomc.services.EmailService;
import com.davidson.cursomc.services.MockEmailService;
import com.davidson.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")//Beans de config daqui só serão ativos quando o properties ativado for o application-test
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailservice() {
		return new SmtpEmailService();
	}

}
